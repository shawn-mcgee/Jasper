package jasper.engine;

import jasper.data.ArrayStack;

public class Engine {
    protected static final ArrayStack<Process>
        INDEX     =    new ArrayStack<Process>();
    
    public static void attach(Process process) {
        if(process != null && INDEX.excludes(process)) {
            INDEX.insert(process);
            process.onAttach();
        }
    }
    
    public static void detach(Process process) {
        if(process != null && INDEX.includes(process)) {
            process.onDetach();
            INDEX.remove(process);
        }
    }
    
    public static void init(Process process, boolean attach) {
        if(process != null && !process.running) {
            if(attach) attach(process);
            
            process.process = new Thread(process);
            process.running =  true;
            process.process.start();
        }
    }
    
    public static void stop(Process process, boolean detach) {
        if(process != null &&  process.running) {
            if(detach) detach(process);
            
            process.running = false;
        }
    }
    
    public static void init(Process process) {
        init(process, true);
    }
    
    public static void stop(Process process) {
        init(process, true);
    }
    
    public static void init() {
        for(Process process: INDEX)
            init(process, false);
    }
    
    public static void exit() {
        for(Process process: INDEX)
            stop(process, false);
    }
}
