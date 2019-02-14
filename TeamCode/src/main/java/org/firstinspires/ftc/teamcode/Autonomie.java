
package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.RobotConfigNameable;
import com.qualcomm.robotcore.util.ElapsedTime;



@Autonomous(name="Autonomie", group="")
public class Autonomie extends LinearOpMode {

    public hardware  robot      = new hardware();
    public ElapsedTime runtime    = new ElapsedTime();
    int red; // 0
    int green; // 85
    int blue; // 150
    //int[][][] culoare = new int[red][green][blue];

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
            red = robot.colorSensor.red();
            green = robot.colorSensor.green();
            blue = robot.colorSensor.blue();




            telemetry.addData("Red:",red);
            telemetry.addData("Green:",green);
            telemetry.addData("Blue:",blue);
            telemetry.addData("Color:","[%d][%d][%d]",red,green,blue);
        }
    }
}
