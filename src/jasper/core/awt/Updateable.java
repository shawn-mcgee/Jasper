package jasper.core.awt;

public interface Updateable {
    public void onUpdate(UpdateContext context);
    
    public static class UpdateContext {
        protected UpdateContext
            parent;

        public Stage
            stage;
        public Input
            input;
        public float
            t,
            dt,
            fixed_dt;
        public int
            canvas_w,
            canvas_h;
        
        public UpdateContext push() {
            UpdateContext context = new UpdateContext();
        
            context.parent = this;
            context.stage = stage;
            context.input = input;
            context.t  = t ;
            context.dt = dt;
            context.fixed_dt = fixed_dt;
            context.canvas_w = canvas_w;
            context.canvas_h = canvas_h;
            
            return context;
        }
        
        public UpdateContext pull() {
            if(parent != null)
                try {
                    return parent;
                } finally {
                    parent = null;
                }
            return this;
        }
    }
}
