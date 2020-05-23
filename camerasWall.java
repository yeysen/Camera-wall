import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 
import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class camerasWall extends PApplet {





Capture cam;
Serial DATA;
int cople;

//int inByte;
public void setup() {
    println(Serial.list());     
    DATA = new Serial(this, Serial.list()[3], 9600);
  
  //fullScreen(2);
  frameRate(60);


  String[] cameras = Capture.list();

  if (cameras == null) {
    println("Failed to retrieve the list of available cameras, will try the default...");
    cam = new Capture(this, 780, 460);
  } if (cameras.length == 0) {
    println("There are no cameras available for capture.");
    exit();
  } else {
    println("Available cameras:");
    printArray(cameras);

    cam = new Capture(this, cameras[86]); //86
    //cam = new Capture(this, 640, 480, "Built-in iSight", 30);
    
    // Start capturing the images from the camera
    cam.start();
  }
}

int runc=1;
int tu;

public void draw() {
  

  
  if (cam.available() == true) {
    cam.read();

  }
 

  image(cam, 0, 0, width, height);
  // is faster when just drawing the image without any additional 
  //set(0, 0, cam);
 
    
   
    int inByte = DATA.read();
    
    int rec=inByte;
   // String letter = DATA.read();
   
    
   if( inByte>=1&&inByte<7){
    saveFrame("C:/Users/yeysen/Documents/clubCode/camerasWall/hot/pic.png");
     tu= inByte-3;
int temp = inByte-3;
  for (int i = 0; i < temp; i = i+1) {
  

 launch("C:/Users/yeysen/Documents/clubCode/camerasWall/you son of a bich.bat");
 
runc=runc+1;


  }
  count=1;
   

  }
  
  
  
  if(rec==8){
    cople=1;
     
  }
  
  if(rec==9){
    cople=0;
  }
  
  
  if(cople==1){
    pre();

  }
  
 
  
  
}




int count;


public void pre(){

    // int count = DATA.read()*-5;
background(42);
fill(20,255,19);
textSize(99);
  
count=count+1;
text("Printing...",(width/2)-200,height/2);
text(tu,(width/2)-300,height/2);
delay(1000);


}

  
  public void settings() {  size(1020, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "camerasWall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
