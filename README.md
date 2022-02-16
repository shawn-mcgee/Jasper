## What is Jasper?

Jasper is a Java game engine. Or at least I tell myself that is what it will be
when it grows up. In its current state, the project is arguably still in its
infancy, but it contains a rudimentary yet robust feature set that is constantly
growing.

The project's namesake comes from the semi-precious, sedimentary mineral known 
as Jasper; more specifically, the slow and accumulative nature of the gemstone's
formation. Despite my best efforts, I am fortunate enough to have a loving 
family and a full-time job that keep me busy. Crucially, I have known from the 
beginning that progress would be similarly sedimentary, and that perhaps with 
enough time and effort, my little rock would also be a semi-precious mineral
someday. So, the name seemed to be a proper fit.

## Why is Jasper?

Generally speaking, Java is not the first language that comes to mind when
thinking about game development, but I believe that is because Java game 
development represents an under-served niche. I believe the Java ecosystem lacks
the tools to make game design accessible to both artists and programmers. It is 
my hope to someday fill this perceived need with a suite of Java based tools.

## Features

Jasper comes with a lightweight logging utility called `Debug`.

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

Jasper  minimizes the boilerplate required to start drawing to the screen.

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

Jasper also comes with a high-performance Vector math library.

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
        
        Debug.info( mul(5, v4(1, 2, 3, 4)   ) ); // v4 scalar multiplication
        Debug.info( div(   v3(1, 2, 3   ), 4) ); // scalar v3 division
        
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

## Roadmap

As Jasper continues to mature, my immediate priorities are:

### Graphics
At its inception, I intended to realize a full 2D and 3D game engine in pure 
Java. While not impossible, it has quickly become obvious that `java.awt` simply
does not have the reasonable performance necessary for 3D. Moving forward, the
goal is to include support for rendering backend like OpenGL and Vulkan via 
[LWJGL](https://www.lwjgl.org).

### Audio
Jasper lacks any audio capabilities at the moment, but the goal is to support 
multiple audio backends like Java's `javax.sound.sampled` and OpenAL via
[LWJGL](https://www.lwjgl.org).

### Multithreading
In its current state, Jasper is mostly single threaded with little support for
parallelization. I believe that determinism is an important anchor for both 
programmers and animators to be able to rely on, which is why it is so important
to get this aspect right. Moving forward, the goal is to expose multithreaded
behavior in a way that doesn't break this contract.

### Documentation
Because of its existence as a solo hobby project, Jasper has little or no 
documentation. High quality documentation and tutorials are a must and the goal 
is to add them incrementally as new features begin to crystallize.