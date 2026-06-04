package org.rowlandhall;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;
import java.util.ArrayList;


/**
 * The Robot class is the main class that represents the robot. It contains all
 * subsystems and is responsible for updating them during the teleop phase.
 * 
 * The Robot class is designed to be used in an OpMode, and it takes in the OpMode as a parameter in its constructor. This allows the Robot class to access the
 * hardware map and telemetry of the OpMode, which are necessary for controlling the robot and providing feedback to the drivers.
 * 
 * To assist with testing and modularity, the Robot class also allows for subsystems to be registered with it. 
 * This means that you can create separate classes for different subsystems of the robot (e.g. drive train, arm, etc.) and register them with the Robot class. The Robot class will then call the operatorUpdate method of each subsystem during the teleop phase, 
 * allowing them to update their state based on the operator control inputs.
 */
public class Robot {
    private final OpMode opmode;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private DriveTrain driveTrain;
    private final List<Subsystem> subsystems;


    /**
     * The Robot class is designed to be used in an OpMode, and it takes in the OpMode as a parameter in its constructor. 
     * This constructor allows you to have a robot that does not have a drive train to make subsystem testing easier and more modular.
     * 
     * @param opmode The OpMode that the robot is being used in. This allows the Robot class to access the hardware map and telemetry of the OpMode, which are necessary for controlling the robot and providing feedback to the drivers.
     */
    public Robot(OpMode opmode) {
        this.opmode = opmode;
        this.hardwareMap = opmode.hardwareMap;
        this.telemetry = opmode.telemetry;
        subsystems = new ArrayList<>();
    }

    /**
     * This constructor allows you to create a robot with a drive train, which is the most common subsystem. It takes in the OpMode and the DriveTrain as parameters, and it registers the DriveTrain as a subsystem of the Robot.
     * @param opmode The OpMode that the robot is being used in. This allows the Robot class to access the hardware map and telemetry of the OpMode, which are necessary for controlling the robot and providing feedback to the drivers.
     * @param dt The DriveTrain subsystem of the robot. This is the most common subsystem, and it is registered as a subsystem of the Robot in this constructor.
     */
    public Robot(OpMode opmode, DriveTrain dt) {
        this(opmode);
        this.driveTrain = dt;
        subsystems.add(dt);
    }

    /**
     * This method allows you to register a subsystem with the Robot, allowing for a modular approach to configuring the robot.
     * 
     * @param s The subsystem to be registered with the Robot. 
     */
    public void registerSubsystem(Subsystem s) {
        subsystems.add(s);
    }

    /**
     * This method is called during the teleop phase of the OpMode within the operational loop, and it updates all subsystems of the robot based on the operator control inputs.
     */
    public void operatorUpdate(OperatorControl oc) {
        for (Subsystem s : subsystems) {
            s.operatorUpdate(oc);
        }
    }

}
