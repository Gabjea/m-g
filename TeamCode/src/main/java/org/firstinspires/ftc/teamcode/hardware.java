
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardware
{
    /* Public OpMode members. */
    public DcMotor MS = null;
    public DcMotor MD =null;

    public ColorSensor sensorColor;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public hardware(){
    }
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        // Define and Initialize Motors
        MS = hwMap.get(DcMotor.class, "ms");
        MD = hwMap.get(DcMotor.class, "md");
        sensorColor= hwMap.get(ColorSensor.class, "sensor_culoare");
        MS.setDirection(DcMotor.Direction.FORWARD);
        MD.setDirection(DcMotor.Direction.REVERSE);
        // Set all motors to zero power
        MS.setPower(0);
        MD.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        MS.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        MD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
 }

