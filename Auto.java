 /**
  * Autonomus documentation. Last updated 2025-01-09
  *
  * place to write script: function(seconds); OR function(); for non time related functions (marked with star)
  * available functions
    -------------------------------------------
    driving: driveF, driveB, strafeL, strafeR, 
    turning: turnL, turnR, 
    sabre:   armIn, armOut, armUp, armDown, 
    claw:    grab*, release* // will not work until the claw is on !!!
             buffer
    -------------------------------------------
  */

 package org.firstinspires.ftc.teamcode;
 import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
 import com.qualcomm.robotcore.hardware.HardwareDevice;
 import com.qualcomm.robotcore.hardware.Servo;
 import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
 import com.qualcomm.robotcore.hardware.DcMotorSimple;
 import com.qualcomm.robotcore.eventloop.opmode.OpMode;
 import com.qualcomm.robotcore.util.ElapsedTime;
 import com.qualcomm.robotcore.hardware.DcMotor;
 import com.qualcomm.*;

 @Autonomous
 
 public class Auto extends LinearOpMode {
     public static final double DRIVE_POWER = 1;
     public static final double SABER_POWER = 1;
     public static final double powerON = 1;
     public static final double powerOFF = 0;
     
     DcMotor right_Front, right_Back, left_Front, left_Back;
     DcMotor lightSaber, saberBase; 
     //Servo claw; // uncomment me when the claw is on !!!
     // challenges
     ElapsedTime timer; // initialize timer 
     public void runOpMode() {
         initializeHardware();  
         waitForStart();
         while(opModeIsActive()){ 
             telemetry.update();
 
           // vehiclular speed: ~2.11ft/s
           // 10ft in 4.74s
           // rotational speed: ?
           driveF(1.0);
           driveB(0.5);
           strafeR(1.0);
           driveB(2.0);
           strafeL(1.0);
 
         }
     }
 
     private void initializeHardware() {
         try {
             right_Back = hardwareMap.dcMotor.get("right_Back"); //motor port 0, hub 1
             right_Front = hardwareMap.dcMotor.get("right_Front"); //motor port 3, hub 1
             left_Front = hardwareMap.dcMotor.get("left_Front"); //motor port 2, hub 1
             left_Back = hardwareMap.dcMotor.get("left_Back"); //motor port 1, hub 1
 
             lightSaber = hardwareMap.dcMotor.get("lightSaber");
             saberBase = hardwareMap.dcMotor.get("saberBase");
            // claw = hardwareMap.servo.get("claw"); // uncomment me when the claw is on!!!
     
             left_Front.setDirection( DcMotorSimple.Direction.FORWARD);
             right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
             left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
             right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         } catch (Exception e) {
             telemetry.addData("Error", "Failed to initialize hardware: " + e.getMessage());
             telemetry.update(); 
         }
     }
     // RIGHT IS POSITIVE, LEFT IS NEGATIVE
     private void driveF(double time) {
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
         left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
         right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
         right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         
         while(timer.seconds <= time){
             right_Front.setPower(powerON);
             right_Back.setPower(powerON);
             left_Front.setPower(-powerON);
             left_Back.setPower(-powerON);
         }
         
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);
         
     }
     private void driveB(double time) {
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
         left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
         right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
         right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         
         while(timer.seconds <= time){
             right_Front.setPower(-powerON);
             right_Back.setPower(-powerON);
             left_Front.setPower(powerON);
             left_Back.setPower(powerON);
         }
         
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);   
     }
     private void strafeL(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
         left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
         right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
         right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         while(timer.seconds <= time){
         right_Front.setPower(-0.5);
         right_Back.setPower(0.5);
         left_Front.setPower(0.5);
         left_Back.setPower(-0.5);
         }
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);   
         
     }
     private void strafeR(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
          left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
          right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
          right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         while(timer.seconds <= time){
         right_Front.setPower(0.5);
          right_Back.setPower(-0.5);
          left_Front.setPower(-0.5);
          left_Back.setPower(0.5);
         }
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);   
      }
     private void turnR(double time) {
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
         left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
         right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
         
         while(timer.seconds <= time){
             right_Front.setPower(-powerON);
             right_Back.setPower(-powerON);
             left_Front.setPower(powerON);
             left_Back.setPower(powerON);
         }
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);   
     }
     private void turnL(double time) {
         ElapsedTime timer = new Timer();
         waitForStart();
         left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
         left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
         right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
         right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
         
         while(timer.seconds <= time){
             right_Front.setPower(-powerON);
             right_Back.setPower(-powerON);
             left_Front.setPower(powerON);
             left_Back.setPower(powerON);
         }
         right_Front.setPower(powerOFF);
         right_Back.setPower(powerOFF);
         left_Front.setPower(powerOFF);
         left_Back.setPower(powerOFF);   
     }
     private void buffer(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
             right_Front.setPower(0);
             right_Back.setPower(0);
             left_Front.setPower(0);
             left_Back.setPower(0);
             tiltSaber(0, false);
             expandSaber(0, false);
         }
         
     }
     /* uncomment me when the claw is on!!!
     private void grab(){
         waitForStart();
     claw.setPosition(1);
     }
     private void release(){
         waitForStart();
     claw.setPosition(0);
     }
     */
     private void tiltSaber(double power, boolean up) {
         saberBase.setDirection(up ? DcMotorSimple.Direction.FORWARD : DcMotorSimple.Direction.REVERSE);
         saberBase.setPower(power);
     }
     
     private void expandSaber(double power, boolean expand) {
         lightSaber.setDirection(expand ? DcMotorSimple.Direction.FORWARD : DcMotorSimple.Direction.REVERSE);
         lightSaber.setPower(power);
     }
     private void armUp(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
         tiltSaber(SABER_POWER, true);
         }
         tiltSaber(0, false);
     }
     private void armDown(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
         tiltSaber(SABER_POWER, false);
         }
         tiltSaber(0, false);
     }
     private void armIn(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
         expandSaber(SABER_POWER, false);
         }
         expandSaber(0, false);
         
     }
     private void armOut(double time){
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
         expandSaber(SABER_POWER, true);
         }
         expandSaber(0, false);
     }
     /*
         ElapsedTime timer = new Timer();
         waitForStart();
         while(timer.seconds <= time){
         
         }
      */
     /*
         private void handleSaberControls() {
                  if (gamepad1.left_trigger > 0) {
                      tiltSaber(SABER_POWER, true);
                  } else if (gamepad1.left_bumper) {
                      tiltSaber(SABER_POWER, false);
                  } else if (gamepad1.right_trigger > 0) {
                      expandSaber(SABER_POWER, true);
                  } else if (gamepad1.right_bumper) {
                      expandSaber(SABER_POWER, false);
                  } else {
                      tiltSaber(0, false);
                      expandSaber(0, false);
                  }
          }
      */
 }
 
 