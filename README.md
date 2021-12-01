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
        // A Stage is a process responsible for updating and rendering Scenes
        Stage stage = new Stage();
        
        // A Stage can be easily configured manually
        stage.configure(
            Stage.WINDOW_BORDER    , false           ,
            Stage.CANVAS_BACKGROUND, "255, 0, 0, 255"
        );
        // Or via a human-readable configuration file
        stage.loadConfiguration("example.cfg");
        
        // The Engine is a singleton that manages all processes in a project
        Engine.attach(stage);
        
        // A Scene can be extended anonymously or via a custom class
        stage.setScene(new Scene() {
            @Override
            public void onRender(RenderContext context) {
                // A RenderContext makes it trivial to chain basic draw calls
                context
                    .color3i(0, 255, 0)
                    .rect(0, 0, 128, 128, true);
            }
        });
    }
}
```

Jasper comes with a high-performance Vector math library.

```java
package com.example;

import jasper.util.Debug;

// Jasper contains a variety of Vector types
import jasper.math.Vector;
import jasper.math.Vector2;
import jasper.math.Vector3;
import jasper.math.Vector4;

// Jasper supports hundreds of Vector operations
import static jasper.math.Vector.*;

public class Example {
    public static void main(String[] args) {
        // Each Vector type is immutable by default, with a mutable sub-type
        Vector
            a = new Vector2(), b = new Vector2.Mutable(),
            c = new Vector3(), d = new Vector3.Mutable(),
            e = new Vector4(), f = new Vector4.Mutable();
        
        // Jasper exposes a handful of convenience methods for creating Vectors on the fly
        Vector2 g = v2(0, 0);
        Vector3 h = v3(0, 0, 0);
        Vector4 i = v4(0, 0, 0, 0);
                
        // Many Vector operations work between types
        Debug.info( add(v2(1, 2), v3(3, 4, 5   )) ); // v2 v3 addition
        Debug.info( sub(v2(1, 2), v4(3, 4, 5, 6)) ); // v2 v4 subtraction
        
        Debug.info( mul(v4(1, 2, 3, 4), 5) ); // v4 scalar multiplication
        Debug.info( div(v3(1, 2, 3   ), 4) ); // v3 scalar division
        
        // Each Vector type can be parsed from a human-readable String
        Debug.info( Vector2.fromString("1, 2") );
        // Vector parsing also supports named fields
        Debug.info( Vector4.fromString( "1, 2, x:3, y:4") );
    }
}
```

```
[Info] <4.0, 6.0, 5.0>
[Info] <-2.0, -2.0, -5.0, -6.0>
[Info] <5.0, 10.0, 15.0, 20.0>
[Info] <0.25, 0.5, 0.75>
[Info] <1.0, 2.0>
[Info] <3.0, 4.0, 1.0, 2.0>
```
