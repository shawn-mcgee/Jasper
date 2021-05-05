package jasper.core;

import jasper.util.Array;

public class Engine {
    protected static final Engine
        INSTANCE = new Engine();
    
    protected final Array.Stack<Server>
        index = new Array.Stack<Server>();
    
    private Engine() {
        // do nothing
    }
    
    public static <T> void queue(T event) {
        INSTANCE.onQueue(event);
    }
    
    public static void init(Server server) {
        INSTANCE.onInit(server);
    }
    
    public static void stop(Server server) {
        INSTANCE.onStop(server);
    }
    
    public static void exit() {
        INSTANCE.onExit();
    }
    
    public <T> void onQueue(T event) {
        for(Server server : index)
            server.queue(event);
    }
    
    public void onInit(Server server) {
        if(server != null) {
            if(index.excludes(server))
                index.insert(server);
            if(!server.running) {
                server.process = new Thread(server);
                server.running =  true;
                server.process.start();
            }
        }
    }
    
    public void onStop(Server server) {
        if(server != null) {
            if(index.includes(server))
                index.remove(server);
            if( server.running) {
                server.running = false;
            }
        }
    }
    
    public void onExit() {
        for(Server server : index)
            stop(server);
    }
}
