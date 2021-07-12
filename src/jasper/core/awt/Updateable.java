package jasper.core.awt;

public interface Updateable {
    public void onUpdate(UpdateContext context);
    
    class UpdateContext {
        protected UpdateContext
            parent;
        
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
