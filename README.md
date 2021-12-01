### What is Jasper?

### Features

Jasper comes with a lightweight logging utility called Debug.

```java
package com.example;

import jasper.util.Debug;
import jasper.Jasper;

public class Example {
    public static void main(String[] args) {
        // Debug can use anonymous objects to trace the method call site
        Debug.info(new Object() { }, Jasper.VERSION);
    }
}
```

```
[com.example.Example.main] Jasper 0.4.1
```

Jasper dramatically minimizes the boilerplate required to start drawing to the screen.

```java
package com.example;

import jasper.core.Engine;
import jasper.core.awt.Stage;
import jasper.core.awt.Scene;

public class Example {
    public static void main(String[] args) {
        // A Stage is a process responsible for updating and rendering scenes
        Stage stage = new Stage();
        
        // A Stage can be easily configured manually
        stage.setProperty(Stage.WINDOW_BORDER    , false           );
        stage.setProperty(Stage.CANVAS_BACKGROUND, "255, 0, 0, 255");
        // Or via a human-readable configuration file
        stage.loadConfiguration("example.cfg");
        
        // The Engine is a singleton that manages all processes in the project
        Engine.attach(stage);
        
        // A Scene can be extended via a custom class or anonymously
        stage.setScene(new Scene() {
            @Override
            public void onRender(RenderContext context) {
                // A RenderContext makes it trivial to chain basic draw calls
                context
                    .color3i(0, 255, 0)
                    .rect(0, 0, 32, 32, true);
            }
        });
    }
}
```