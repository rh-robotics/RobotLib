package org.rowlandhall;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * OperatorControl encapsulates the controllers used by the operators during the
 * teleop phase
 * of gameplay.
 */
public class OperatorControl {

    private Gamepad currentGamepad1, currentGamepad2, previousGamepad1, previousGamepad2;
    private Vector2d gp1LeftStick, gp1RightStick, gp2LeftStick, gp2RightStick;

    /**
     * The OperatorControl class is responsible for keeping track of the current and previous states of the gamepads, as well as the left and right stick positions. This allows subsystems to easily access the operator control inputs and update their state accordingly during the teleop phase.
     */
    public OperatorControl(Gamepad g1, Gamepad g2) {
        currentGamepad1 = new Gamepad();
        currentGamepad2 = new Gamepad();
        previousGamepad1 = new Gamepad();
        previousGamepad2 = new Gamepad();
        currentGamepad1.copy(g1);
        currentGamepad2.copy(g2);
    }

    /**
     * This method is called at the beginning of each loop during the teleop phase, and it updates the current and previous gamepad states, as well as the left and right stick positions. 
     */
    public void updateGamepads(Gamepad g1, Gamepad g2) {
        previousGamepad1.copy(currentGamepad1);
        previousGamepad2.copy(currentGamepad2);
        currentGamepad1.copy(g1);
        currentGamepad2.copy(g2);
        gp1LeftStick = new Vector2d(currentGamepad1.left_stick_x, currentGamepad1.left_stick_y);
        gp1RightStick = new Vector2d(currentGamepad1.right_stick_x, currentGamepad1.right_stick_y);
        gp2LeftStick = new Vector2d(currentGamepad2.left_stick_x, currentGamepad2.left_stick_y);
        gp2RightStick = new Vector2d(currentGamepad2.right_stick_x, currentGamepad2.right_stick_y);
    }

    /**
     * Returns the current state of gamepad 1 - Left Stick as a Vector2d. This can be used by subsystems to access the operator control inputs from gamepad 1.
     * @return The current state of gamepad 1 - Left Stick as a Vector2d
     */
    public Vector2d getGp1LeftStick() {
        return gp1LeftStick;
    }

    /**
     * Returns the current state of gamepad 1 - Right Stick as a Vector2d. This can be used by subsystems to access the operator control inputs from gamepad 1.
     * @return The current state of gamepad 1 - Right Stick as a Vector2d
     */
    public Vector2d getGp1RightStick() {
        return gp1RightStick;
    }

    /**
     * Returns the current state of gamepad 2 - Left Stick as a Vector2d. This can be used by subsystems to access the operator control inputs from gamepad 2.
     * @return The current state of gamepad 2 - Left Stick as a Vector2d
     */
    public Vector2d getGp2LeftStick() {
        return gp2LeftStick;
    }

    /**
     * Returns the current state of gamepad 2 - Right Stick as a Vector2d. This can be used by subsystems to access the operator control inputs from gamepad 2.
     * @return The current state of gamepad 2 - Right Stick as a Vector2d
     */
    public Vector2d getGp2RightStick() {
        return gp2RightStick;
    }

}
