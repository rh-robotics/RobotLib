package org.rowlandhall;

/**
 * The Subsystem interface represents a subsystem of the robot, such as the drive train, arm, etc. It contains a single method, operatorUpdate, which is called during the teleop phase of the OpMode within the operational loop. This method allows the subsystem to update its state based on the operator control inputs.
 */
public interface Subsystem {
    void operatorUpdate(OperatorControl oc);
}
