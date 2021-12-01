package jasper.core;

import jasper.util.Callback;

import java.util.LinkedHashSet;

public final class Engine {
    private static final Engine
        INSTANCE = new Engine();

    private final Module.Worker
        module = new Module.Worker() {
            @Override
            public <T> void queue(T event) {
                synchronized (INSTANCE) {
                    super . queue(event);
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
        };

    private final LinkedHashSet<Module>
        modules = new LinkedHashSet<Module>();
    
    private Engine() {
        // do nothing
    }

    public static void init() {
        INSTANCE.onInit();
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

    public static void async(Callback event) {
        INSTANCE.onAsync(event);
    }

    public static void await(Callback event) {
        INSTANCE.onAwait(event);
    }

    private void onInit() {
        synchronized (INSTANCE) {
            if (!module.running) {
                module.thread = new java.lang.Thread(module);
                module.running = true;
                module.thread.start();
            }
        }
    }
    
    private void onExit() {
        if (module.running)
            module.running = false;
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
        init(); module.async(event);
    }

    private void onAwait(Callback event) {
        init(); module.await(event);
    }
}
