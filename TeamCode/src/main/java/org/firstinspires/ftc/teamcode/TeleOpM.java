
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOpM", group="")

public class TeleOpM extends LinearOpMode {

    DcMotor ms=null;
    DcMotor md=null;

    double powerx,powery,turn;

    @Override
    public void runOpMode() {


        ms= hardwareMap.get(DcMotor.class,"ms");
        md= hardwareMap.get(DcMotor.class,"md");

        ms.setDirection(DcMotor.Direction.REVERSE);
        md.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status: ",  "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

        powerx= gamepad1.left_stick_x;
        powery= gamepad1.left_stick_y;
        turn=  gamepad1.right_stick_x;



        telemetry.addData("powerx ",  powerx);
        telemetry.addData("powery ",  powery);
        telemetry.addData("turn ",  turn);
        telemetry.update();

            // Pace this loop so jaw action is reasonable speed.
            sleep(50);
        }
    }
}
