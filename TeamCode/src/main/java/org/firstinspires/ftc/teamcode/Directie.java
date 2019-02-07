package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Directie {

    public void Miscare(String directie, double power, DcMotor MS, DcMotor MD){

        switch (directie){

            case "fata":
            case "spate": {
                MS.setPower(power);
                MD.setPower(power);
                break;
            }
            case "stanga": {
                MS.setPower(0);
                MD.setPower(-power);
            }

            case "dreapta": {
                MS.setPower(power);
                MD.setPower(0);
            }

            case "rotire_stanga":
            case "rotire_dreapta": {
                MS.setPower(-power);
                MD.setPower(power);

                break;
            }

            case "stop": {
                MS.setPower(0);
                MD.setPower(0);
                break;
            }
        }
    }
}
