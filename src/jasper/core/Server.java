package jasper.core;

import jasper.util.*;
import jasper.util.event.Broker;
import jasper.util.event.Handle;
import jasper.util.event.Listener;

import java.nio.file.Path;
import java.util.TreeMap;

public abstract class Server implements Runnable {
    protected final TreeMap<String, String>
        cfg  =  new TreeMap<String, String>();
    protected final Broker
        broker;
    protected final Handle
        handle;
    
    protected volatile boolean
        running;
    protected Thread
        process;
    
    public Server() {
        broker = new Broker();
        handle = new Handle();
        broker.onAttach(handle);
    }
    
    public void init() { Engine.init(this); }
    public void stop() { Engine.stop(this); }
    
    public void onInit() throws Exception { }
    public void onStep() throws Exception { }
    public void onStop() { }
    
    public void configure(Object... args) {
        Configuration.configure(cfg, args);
    }
    
    public void loadConfiguration(Class<?> loader, String path) {
        Configuration.load(cfg, loader, path);
    }
    
    public void loadConfiguration(String path) {
        Configuration.load(cfg, path);
    }
    
    public void loadConfiguration(Path   path) {
        Configuration.load(cfg, path);
    }
    
    public void saveConfiguration(String path) {
        Configuration.save(cfg, path);
    }
    
    public void saveConfiguration(Path   path) {
        Configuration.save(cfg, path);
    }
    
    public String setProperty(Object key, Object val) {
        return Configuration.setProperty(cfg, key, val);
    }
    
    public <OBJECT> String setProperty(Object key, ObjectToString<OBJECT> o2s, OBJECT val            ) {
        return Configuration.setProperty(cfg, key, o2s, val     );
    }
    
    public <OBJECT> String setProperty(Object key, ObjectToString<OBJECT> o2s, OBJECT val, String alt) {
        return Configuration.setProperty(cfg, key, o2s, val, alt);
    }
    
    public String getProperty(Object key            ) {
        return Configuration.getProperty(cfg, key     );
    }
    
    public String getProperty(Object key, Object alt) {
        return Configuration.getProperty(cfg, key, alt);
    }
    
    public <OBJECT> OBJECT getPropertyAs(Object key, StringToObject<OBJECT> s2o            ) {
        return Configuration.getPropertyAs(cfg, key, s2o     );
    }
    
    public <OBJECT> OBJECT getPropertyAs(Object key, StringToObject<OBJECT> s2o, OBJECT alt) {
        return Configuration.getPropertyAs(cfg, key, s2o, alt);
    }
    
    public <T> void attach(Class<T> type, Listener<T> listener) {
        handle.attach(type, listener);
    }
    
    public <T> void detach(Class<T> type, Listener<T> listener) {
        handle.detach(type, listener);
    }
    
    public void attach(Broker broker) {
        this.broker.attach(broker);
    }
    
    public void detach(Broker broker) {
        this.broker.detach(broker);
    }
    
    public void attach(Handle handle) {
        this.broker.attach(handle);
    }
    
    public void detach(Handle handle) {
        this.broker.detach(handle);
    }
    
    public <T> void queue(T event) {
        broker.queue(event);
    }
    
    public <T> void flush(T event) {
        broker.flush(event);
    }
    
    public void poll() {
        broker.poll();
    }
    
    @Override
    public void run() {
        try {
            onInit();
            while(running)
                onStep();
        } catch(Exception fatal) {
            Debug.warn(new Object() { }, "A fatal exception has occurred in module '" + getClass().getName() + "'");
            fatal.printStackTrace();
        } finally {
            onStop();
        }
    }
}
