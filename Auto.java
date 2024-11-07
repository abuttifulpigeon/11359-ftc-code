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

    // Initialize required motors and servos
    DcMotor right_Front, right_Back, left_Front, left_Back;
    // Servo is an object, dont forget dummy

    @Override
    public void runOpMode() {

        
        // Defined Motors and Old Motors
        
        right_Back = hardwareMap.dcMotor.get("right_Back"); //motor port 0, hub 1
        right_Front = hardwareMap.dcMotor.get("right_Front");//motor port 3, hub 1
        left_Front = hardwareMap.dcMotor.get("left_Front");//motor port 2, hub 1
        left_Back = hardwareMap.dcMotor.get("left_Back");//motor port 1, hub 1

        //arm = hardwareMap.dcMotor.get("arm");//motor port 2, hub 2
        //arm = hardwareMap.dcMotor.get("arm");//
        // Defined Servos and Old Servos

        //clawPrim = hardwareMap.servo.get("clawPrim");//servo port 0, hub1
        
        // Only Reversed Motor
        //clawPrim.setDirection(Servo.Direction());
        
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        // When Game Starts / Controls
       
        waitForStart();
        while(opModeIsActive()){
            
            
        }
    }    

    private void driveF(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);

        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    private void driveB(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);

        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    private void driveL(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    private void driveR(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    private void turnL(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }

    private void turnR(float time) {
        left_Front.setDirection(DcMotorSimple.Direction.FORWARD);
        left_Back.setDirection(DcMotorSimple.Direction.FORWARD);
        right_Front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Back.setDirection(DcMotorSimple.Direction.REVERSE);
        
        right_Front.setPower(right_Frontpow);
        right_Back.setPower(right_Backpow);
        left_Front.setPower(left_Frontpow);
        left_Back.setPower(left_Backpow);

        sleep(time);

        right_Front.setPower(0);
        right_Back.setPower(0);
        left_Front.setPower(0);
        left_Back.setPower(0);
    }
}
