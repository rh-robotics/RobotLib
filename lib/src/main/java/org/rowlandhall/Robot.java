package org.rowlandhall;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;
import java.util.ArrayList;

public class Robot {
    private final OpMode opmode;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private DriveTrain driveTrain;
    private final List<Subsystem> subsystems;



    public Robot(OpMode opmode) {
        this.opmode = opmode;
        this.hardwareMap = opmode.hardwareMap;
        this.telemetry = opmode.telemetry;
        subsystems = new ArrayList<>();
    }

    public Robot(OpMode opmode, DriveTrain dt) {
        this(opmode);
        this.driveTrain = dt;
        subsystems.add(dt);
    }

    public void registerSubsystem(Subsystem s) {
        subsystems.add(s);
    }

    public void controllerUpdate(Gamepad gp1, Gamepad gp2) {
        for (Subsystem s : subsystems) {
            s.controllerUpdate(gp1, gp2);
        
        }
    }

}
