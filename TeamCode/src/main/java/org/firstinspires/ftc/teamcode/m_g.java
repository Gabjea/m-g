package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="m_g", group="")

public class m_g extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    double powerX;
    double powerY;

    DcMotor MS;
    DcMotor MD;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");


        MS  = hardwareMap.get(DcMotor.class, "ms");
        MD = hardwareMap.get(DcMotor.class, "md");


        MS.setDirection(DcMotor.Direction.REVERSE);
        MD.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        powerY = gamepad1.left_stick_y;
        powerX = -gamepad1.right_stick_x;

        if(powerY > 0.1){
            MS.setPower(-powerY);
            MD.setPower(powerY);
        }else if(powerY < -0.1){
            MS.setPower(-powerY);
            MD.setPower(powerY);
        }else if(powerX > 0.1){
            MS.setPower(powerX);
        }else if(powerX < -0.1){
            MD.setPower(powerX);
        }else{
            MS.setPower(0);
            MD.setPower(0);
        }

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "power (%.2f)", powerY);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
