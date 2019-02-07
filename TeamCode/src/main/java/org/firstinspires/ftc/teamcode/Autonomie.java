
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
    double culoare = 0;

    Directie Directie = new Directie();
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);


        telemetry.addData("Status: ",  "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        robot.colorSensor.enableLed(true);
        while(opModeIsActive()) {
            if (robot.colorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER) == 0) {
                Directie.Miscare("fata", 1, robot.MS, robot.MD);
            }
            Directie.Miscare("stop", 0, robot.MS, robot.MD);
            Directie.Miscare("rotire_stanga", 0.3, robot.MS, robot.MD);
            sleep(1000);
            Directie.Miscare("stop", 0, robot.MS, robot.MD);
            if (robot.colorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER) != 0) {
                Directie.Miscare("rotire_dreapta", 0.6, robot.MS, robot.MD);
                sleep(1000);
                Directie.Miscare("stop", 0, robot.MS, robot.MD);
            }
            telemetry.addData("Color Number: ", robot.colorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER));
            telemetry.update();
        }
    }
}
