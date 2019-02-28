
package org.firstinspires.ftc.teamcode;


import android.graphics.Color;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.RobotConfigNameable;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;


@Autonomous(name="Autonomie", group="")
public class Autonomie extends LinearOpMode {

    public hardware  robot      = new hardware();
    public ElapsedTime runtime    = new ElapsedTime();
    int hue =0;
    Directie Directie = new Directie();
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);


        telemetry.addData("Status: ",  "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)

        while(opModeIsActive()) {
            // albastru : red 40-70, green 50-75, blue 50
            // -80
            // negru : red 25-50, green 20-45, blue 17-35

            float hsvValues[] = {0F, 0F, 0F};

            // values is a reference to the hsvValues array.
            final float values[] = hsvValues;

            // sometimes it helps to multiply the raw RGB values with a scale factor
            // to amplify/attentuate the measured values.
            final double SCALE_FACTOR = 255;

            Color.RGBToHSV((int) (robot.sensorColor.red() * SCALE_FACTOR),
                    (int) (robot.sensorColor.green() * SCALE_FACTOR),
                    (int) (robot.sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);

            hue = (int)hsvValues[0];

            if(hue >=100){
                Directie.Miscare("fata",0.5,robot.MS,robot.MD);
            }else if(hue <21){
                Directie.Miscare("spate",-0.5,robot.MS,robot.MD);
                sleep(100);
                Directie.Miscare("stop",0,robot.MS,robot.MD);
                sleep(500);
                Directie.Miscare("rotire_stanga",0.3,robot.MS,robot.MD);
                sleep(100);
                Directie.Miscare("stop",0,robot.MS,robot.MD);
                if(hue >=100){

                }else {
                    Directie.Miscare("rotire_dreapta",0.6,robot.MS,robot.MD);
                    sleep(500);
                    Directie.Miscare("stop",0,robot.MS,robot.MD);
                }

            }else {
                Directie.Miscare("stop",0,robot.MS,robot.MD);
            }




            // send the info back to driver station using telemetry function.
            telemetry.addData("Hue", hsvValues[0]);
            telemetry.update();
        }
    }
}
