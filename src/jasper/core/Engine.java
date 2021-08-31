package jasper.core;

import jasper.util.Callback;

import java.util.LinkedHashSet;

public final class Engine extends Module.Resolver {
    private static final Engine
        INSTANCE = new Engine();
    private final LinkedHashSet<Module>
        modules = new LinkedHashSet<Module>();
    
    private Engine() {
        // do nothing
    }

    public static void INIT() {
        INSTANCE.onInit();
    }

    public static void EXIT() {
        AWAIT(INSTANCE::onExit);
    }
    
    public static void ATTACH(Module m) {
        ASYNC(() -> INSTANCE.onAttach(m));
    }
    
    public static void DETACH(Module m) {
        ASYNC(() -> INSTANCE.onDetach(m));
    }

    public static void ASYNC(Callback event) {
        INSTANCE.onAsync(event);
    }

    public static void AWAIT(Callback event) {
        INSTANCE.onAwait(event);
    }

    private void onInit() {
        synchronized (INSTANCE) {
            if (!running) {
                thread = new java.lang.Thread(this);
                running = true;
                thread.start();
            }
        }
    }
    
    private void onExit() {
        if (running)
            running = false;
    }
    
    private void onAttach(Module m) {
        if(modules.add   (m))
            m.onAttach();
    }
    
    private void onDetach(Module m) {
        if(modules.remove(m))
            m.onDetach();
    }

    private void onAsync(Callback event) {
        INIT(); async(event);
    }

    private void onAwait(Callback event) {
        INIT(); await(event);
    }

    @Override
    public <T> void queue(T event) {
        super.queue(event);
        synchronized (INSTANCE) {
            INSTANCE.notifyAll();
        }
    }

    @Override
    protected void onStep() throws Exception {
        if(pending() > 0)
            poll();
        else
            synchronized (INSTANCE) {
                INSTANCE.wait();
            }
    }

    @Override
    protected void onStop() {
        modules.forEach(Module::onDetach);
        modules.clear();
    }
}
