
package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOp", group="")

public class TeleOp extends LinearOpMode {

    /* Declare OpMode members. */
    DcMotor MS = null;
    DcMotor MD =null;
   // ModernRoboticsI2cRangeSensor rangeSensor = null;

    double powerX;
    double powerY;
    double turn;

    Directie Directie = new Directie();
    @Override
    public void runOpMode() {


        MS  = hardwareMap.get(DcMotor.class, "ms");
        MD = hardwareMap.get(DcMotor.class, "md");


        MS.setDirection(DcMotor.Direction.FORWARD);
        MD.setDirection(DcMotor.Direction.REVERSE);


        telemetry.addData("Status: ",  "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            powerY = gamepad1.left_stick_y;  // valorile de pe axa OY a joystick-ului stang
            powerX  =  gamepad1.left_stick_x; // valorile de pe axa OX a joystick-ului stang
            turn  =  gamepad1.right_stick_x; // valorile de pe axa OX a joystick-ului drept

            if(powerY > 0.3){ // robotul se misca in fata
                Directie.Miscare("fata",powerY,MS,MD);
            }else if(powerY < -0.3){ // robotul se misca in spate
                Directie.Miscare("spate",powerY,MS,MD);
            }else if(powerX > 0.3){ // robotul se roteste la stanga in jurul rotii stangi
                Directie.Miscare("stanga",powerY,MS,MD);
            }else if(powerX < -0.3){ // robotul se roteste la dreapta in jurul rotii drepti
                Directie.Miscare("dreapta",powerY,MS,MD);
            }else{ // robotul se opreste
                Directie.Miscare("stop",0,MS,MD);
            }

            if(turn > 0.3){ // robotul se roteste pe loc la stanga
                Directie.Miscare("rotire_stanga",turn,MS,MD);
            }else if(turn < -0.3){ // robotul se roteste pe loc la dreapta
                Directie.Miscare("rotire_dreapta",turn,MS,MD);
            }else{ // robotul se opreste
                Directie.Miscare("stop",0,MS,MD);
            }

            telemetry.addData("PowerX: ",  "%.2f", powerX);
            telemetry.addData("PowerY: ", "%.2f", powerY);
            telemetry.addData("TurnPower: ", "%.2f", turn);
            //telemetry.addData("Distance: ", "%.2f", rangeSensor.getDistance(DistanceUnit.CM));
            telemetry.update();

            // Pace this loop so jaw action is reasonable speed.
            sleep(50);
        }
    }
}
