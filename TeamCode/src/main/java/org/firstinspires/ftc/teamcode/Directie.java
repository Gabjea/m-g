package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Directie {

    public void Miscare(String directie, double power, DcMotor MS, DcMotor MD){

        switch (directie){

            case "fata": // robotul se misca in fata
            case "spate": { // robotul se misca in spate
                MS.setPower(power);
                MD.setPower(power);
                break;
            }
            case "stanga": { // robotul se roteste la stanga in jurul rotii stangi
                MS.setPower(0);
                MD.setPower(-power);
            }

            case "dreapta": { // robotul se roteste la dreapta in jurul rotii drepte
                MS.setPower(power);
                MD.setPower(0);
            }

            case "rotire_stanga": // robotul se roteste la stanga pe loc
            case "rotire_dreapta": { // robotul se roteste la dreapta pe loc
                MS.setPower(-power);
                MD.setPower(power);

                break;
            }

            case "stop": { // robotul se opreste
                MS.setPower(0);
                MD.setPower(0);
                break;
            }
        }
    }
}
