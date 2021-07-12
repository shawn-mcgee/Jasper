package jasper.core;

import jasper.util.Callback;

import java.util.LinkedHashSet;

public final class Engine {
    protected static final Engine
        INSTANCE = new Engine();
    
    protected final LinkedHashSet<Module>
        modules = new LinkedHashSet<Module>();
    protected final Module.Worker
        worker = new Module.Worker();
    
    protected Engine() {
        // do nothing
    }
    
    public static void init() {
        synchronized(INSTANCE) {
            INSTANCE.onInit();
        }
    }
    
    public static void exit() {
        await(INSTANCE::onExit);
    }
    
    public static void attach(Module m) {
        async(() -> INSTANCE.onAttach(m));
    }
    
    public static void detach(Module m) {
        async(() -> INSTANCE.onDetach(m));
    }
    
    public static void async(Callback callback) {
        INSTANCE.onAsync(callback);
    }
    
    public static void await(Callback callback) {
        INSTANCE.onAwait(callback);
    }
    
    protected void onInit() {
        if(!worker.running) {
            worker.thread  = new java.lang.Thread(worker);
            worker.running = true;
            worker.thread.start();
        }
    }
    
    protected void onExit() {
        if( worker.running)
            worker.running = false;
        for (Module m : modules)
            m.onDetach();
        modules.clear();
    }
    
    protected void onAttach(Module m) {
        modules.add   (m);
        m.onAttach();
    }
    
    protected void onDetach(Module m) {
        m.onDetach();
        modules.remove(m);
    }
    
    protected void onAsync(Callback callback) {
        worker.async(callback);
    }
    
    protected void onAwait(Callback callback) {
        worker.await(callback);
    }
}
