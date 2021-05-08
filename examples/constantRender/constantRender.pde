import johnnoonan.sketchFrameExporter.*;


SketchFrameExporter exporter;
float c = 0;
float rad = 0;
float maxrad;
float inc = 3;

void setup(){
  size(640, 360);
  frameRate(30);
  colorMode(HSB, height, height, height);
  maxrad = height;  
  exporter = new SketchFrameExporter(this, "data");
  exporter.startRender();
}

void draw(){
  background(0);
  fill(c, height, height);
  ellipse(width/2, height/2, rad, rad);  
  
  c += inc;
  rad += inc;
  c %= 255;
  rad %= maxrad;
  exporter.renderFrame();
}
