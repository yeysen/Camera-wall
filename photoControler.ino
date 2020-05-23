#include <Servo.h>


Servo myservo;

int button = 2;
int copys;
double  val;
int rec;
int realCopy=1;

void setup() {
  myservo.attach(10);
  pinMode(button, INPUT);
  digitalWrite(button, 1);
  Serial.begin(9600);
for(int i=3; i<=9; i++){  
   pinMode(i, OUTPUT);
}

}
void loop() {


if(copys>0){

   realCopy=copys-3;
}





  
 //......................................................
val = analogRead(A0); 
 
  if(val>=78&&val<=180){

 Serial.print( "1" );
  copys=4;
}

if(val>=181&&val<=320){

 Serial.print( "2" );
  copys=5;
}

if(val>=321&&val<=482){

 Serial.print( "3" );
 copys=6;
  
}

//...............................................
  if (digitalRead(button)==LOW){
for(int i=3; i<=9; i++){  
 digitalWrite(i, HIGH);  
  delay(500); 
//Serial.println(i);
}

   Serial.println(copys);
  Serial.write(copys);
  
   myservo.attach(10);
   myservo.write(1);
   delay(1000);
    rec=4;

   for(int i=3; i<=9; i++){  
 digitalWrite(i, LOW);  
  delay(100); 

}

  }else{
    Serial.write(0);
    myservo.detach();
delay(150);
  }

//Serial.print( realCopy );
if(rec==4){
 Serial.write(8);
 delay(50000*realCopy);
  Serial.write(9);
rec=0;
}


  
 
     // delay(450);  
//..........................................................


//Serial.print( copys );





            
  
}
