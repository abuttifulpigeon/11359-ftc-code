package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.*;

@TeleOp(name = "Auto", group = "Autonomous")
public class DriveCode extends LinearOpMode {

    // Initialize required motors and servos
    public static final double DRIVE_POWER = 0.5;
    public static final double SABER_POWER = 0.5;
    public static final double STICK_DEADZONE = 0.25;

    double left_Frontpow = 0;
    double right_Frontpow = 0;
    double left_Backpow = 0; 
    double right_Backpow = 0;
    
    double saberPow = 0;

    // Initialize required motors and servos
    DcMotor right_Front, right_Back, left_Front, left_Back;
    DcMotor lightSaber, saberBase; 
    @Override
    public void runOpMode() {
        initializeHardware();  

       
        waitForStart();
        while(opModeIsActive()){ 
            // When Game Starts / Controls
            handleDriveControls();
            handleSaberControls(); 

        }
    }

    // Init

    private void initializeHardware() {
        try {
            right_Back = hardwareMap.dcMotor.get("right_Back"); //motor port 0, hub 1
            right_Front = hardwareMap.dcMotor.get("right_Front"); //motor port 3, hub 1
            left_Front = hardwareMap.dcMotor.get("left_Front"); //motor port 2, hub 1
            left_Back = hardwareMap.dcMotor.get("left_Back"); //motor port 1, hub 1

            lightSaber = hardwareMap.dcMotor.get("lightSaber");
            saberBase = hardwareMap.dcMotor.get("saberBase");
    
            left_Front.setDirection( DcMotorSimple.Direction.FORWARD);
            right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
            left_Back.setDirection(  DcMotorSimple.Direction.FORWARD);
            right_Back.setDirection( DcMotorSimple.Direction.FORWARD);
        } catch (Exception e) {
            telemetry.addData("Error", "Failed to initialize hardware: " + e.getMessage());
            telemetry.update(); 
        }
    }

    private void handleDriveControls() {
            left_Frontpow = DRIVE_POWER * gamepad1.left_stick_y;
            right_Frontpow = DRIVE_POWER * gamepad1.left_stick_y;
            left_Backpow = DRIVE_POWER * gamepad1.left_stick_y;
            right_Backpow = DRIVE_POWER * gamepad1.left_stick_y;
	        
                        
            // Defined Buttons for driving            
            //main power on left stick
            
          
            //direction on right stick
            left_Frontpow += DRIVE_POWER * -gamepad1.right_stick_x;
            left_Backpow += DRIVE_POWER * -gamepad1.right_stick_x;
            right_Frontpow -= DRIVE_POWER * gamepad1.right_stick_x;
            right_Backpow -= DRIVE_POWER * gamepad1.right_stick_x;
            
            
            //strafe on left stick
            left_Frontpow += DRIVE_POWER * gamepad1.left_stick_x;
            left_Backpow += DRIVE_POWER * gamepad1.left_stick_x;
            right_Frontpow -= DRIVE_POWER * gamepad1.left_stick_x;
            right_Backpow -= DRIVE_POWER * gamepad1.left_stick_x;
            
            

            doAuto();

            
    }

    private void doAuto() {
        

        
        stopD();
    }

    private boolean checkDeadzone(float stickValue) {
        return Math.abs(stickValue) >= STICK_DEADZONE;
    }

    private void handleSaberControls() {
            if (gamepad1.a) {
                tiltSaber(SABER_POWER, true);
            } else if (gamepad1.b) {
                tiltSaber(SABER_POWER, false);
            } else if (gamepad1.x) {
                expandSaber(SABER_POWER, true);
            } else if (gamepad1.y) {
                expandSaber(SABER_POWER, false);
            } else {
                tiltSaber(0, false);
                expandSaber(0, false);
            }
    }

    // Drive Functions

    private void driveF() {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);

        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }

    private void driveB() {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);

        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }

    private void driveL() {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(-left_Frontpow);
        left_Back.setPower(-left_Backpow);
    }

    private void driveR() {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        
        right_Front.setPower(-right_Frontpow);
        right_Back.setPower(-right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }

    private void turnL() {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }

    private void turnR() {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }
    private void stopD() {
 
        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    // Arm Functions

    private void tiltSaber(double power, boolean up) {
        saberBase.setDirection(DcMotorSimple.Direction.FORWARD);
        saberBase.setPower(power);
    }
    
    private void expandSaber(double power, boolean expand) {
        lightSaber.setDirection(expand ? DcMotorSimple.Direction.FORWARD : DcMotorSimple.Direction.REVERSE);
        lightSaber.setPower(power);
    }
}
