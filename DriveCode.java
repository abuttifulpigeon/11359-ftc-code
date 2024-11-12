/**
 * What follows is the code used for the 2024-2025 season of FTC entitled Into the Deep. This code was written as a handme-down from a code template at least 4 years old as of 12 November, 2024. I offer you, young developer from the future, to, if ChatGPT hasn't killed us all yet, continue the legacy of this code. Below are some notes you may find useful, that I wish I had known when I started. I wish you the best of luck. Signed- Jonah T. Silvia (abuttifulpigeon on Github. jonah@thecoup.xyz for any questions).
 * 
 * Servo is an object, dont forget dummy!!!
 *
*/

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

@TeleOp(name = "DriveCode", group = "TeleOp")
public class DriveCode extends LinearOpMode {
    double left_Frontpow = 0;
    double right_Frontpow = 0;
    double left_Backpow = 0;
    double right_Backpow = 0;
    double armPow = 0;
    // Initialize required motors and servos
    DcMotor right_Front, right_Back, left_Front, left_Back arm;// 
    @Override
    public void runOpMode() {
        // Defined Motors and Old Motors
        
        right_Back = hardwareMap.dcMotor.get("right_Back"); //motor port 0, hub 1
        right_Front = hardwareMap.dcMotor.get("right_Front"); //motor port 3, hub 1
        left_Front = hardwareMap.dcMotor.get("left_Front"); //motor port 2, hub 1
        left_Back = hardwareMap.dcMotor.get("left_Back"); //motor port 1, hub 1

        arm = hardwareMap.dcMotor.get("arm");//motor port 0, hub 0
        // Defined Servos and Old Servos

        //clawPrim = hardwareMap.servo.get("clawPrim");//servo port 0, hub1
        
        // Only Reversed Motor
        //clawPrim.setDirection(Servo.Direction());
        
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        
        // When Game Starts / Controls
       
        waitForStart();
        while(opModeIsActive()){  
            double POWER = 0.5;
            left_Frontpow = POWER * -gamepad1.left_stick_y;
            right_Frontpow = POWER * gamepad1.left_stick_y;
            left_Backpow = POWER * gamepad1.left_stick_y;
            right_Backpow = POWER * -gamepad1.left_stick_y;
        
            
            // Defined Buttons for driving            
            //main power on left stick
            
          
            //direction on right stick
            left_Frontpow+= POWER * -gamepad1.right_stick_x;
            left_Backpow+= POWER * -gamepad1.right_stick_x;
            right_Frontpow-= POWER * gamepad1.right_stick_x;
            right_Backpow-= POWER * gamepad1.right_stick_x;
            
            
            //strafe on left stick
            left_Frontpow+= POWER * gamepad1.left_stick_x;
            left_Backpow+= POWER * gamepad1.left_stick_x;
            right_Frontpow-= POWER * gamepad1.left_stick_x;
            right_Backpow-= POWER * gamepad1.left_stick_x;
            
            

            // arcade drive

	    if (gamepad1.right_stick_y <= -.25) {
                turnL();
            } else if (gamepad1.right_stick_y >= .25) {
                turnR();
            } else {
                stopD(); 
            }


            if (gamepad1.left_stick_y <= -.25) {
                driveF();
            } else if (gamepad1.left_stick_y >= .25) {
                driveB();
            } else {
                stopD();
            }

        }
    }    

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

        right_Front.setPower(-right_Frontpow);
        right_Back.setPower(-right_Backpow);
        left_Front.setPower(-left_Frontpow);
        left_Back.setPower(-left_Backpow);
    }

    private void driveL() {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);
    }

    private void driveR() {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
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
}
