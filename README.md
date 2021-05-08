# Sketch Frame Exporter
A utility library for rendering image sequences in Processing

## Basic Usage
```java

import johnnoonan.sketchFrameExporter.*;

SketchFrameExporter exporter;

void setup(){
  // setup canvas
  exporter = new SketchFrameExporter(this, "data");
  exporter.startRender();
}

void draw(){
  // create imagery
  exporter.renderFrame();
}

```