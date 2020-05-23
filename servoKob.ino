

#include <Servo.h>
   
Servo myservo;  // create servo object to control a servo

int button = 7;  
int val;    // variable to read the value from the analog pin
 
void setup() {
    Serial.begin(9600);
  myservo.attach(10);  // attaches the servo on pin 9 to the servo object
   pinMode(button, INPUT);
   digitalWrite(button, HIGH);
}

void loop() {
  val = analogRead(A0);            // reads the value of the potentiometer (value between 0 and 1023)
                  //  the servo position according to the scaled value
  //Serial.print(val);
  //Serial.print( "        " );
  delay(15);   // waits for the servo to get there

if(val>=78&&val<=140){

 Serial.print( "1" );
  
}

if(val>=141&&val<=280){

 Serial.print( "2" );
  
}

if(val>=281&&val<=422){

 Serial.print( "3" );
  
}






if (digitalRead(button)==LOW){
  myservo.attach(10);
myservo.write(5);
}else{

  myservo.detach();
}








}
