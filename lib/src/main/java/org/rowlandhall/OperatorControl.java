package org.rowlandhall;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * OperatorControl encapsulates the controllers used by the operators during the
 * teleop phase
 * of gameplay.
 */
public class OperatorControl {

    private Gamepad currentGamepad1, currentGamepad2, previousGamepad1, previousGamepad2;
    private Vector2d leftStick, rightStick;

    public OperatorControl() {
        currentGamepad1 = new Gamepad();
        currentGamepad2 = new Gamepad();
        previousGamepad1 = new Gamepad();
        previousGamepad2 = new Gamepad();
    }

    public void updateGamepads(Gamepad g1, Gamepad g2) {
        previousGamepad1.copy(currentGamepad1);
        previousGamepad2.copy(currentGamepad2);
        currentGamepad1.copy(g1);
        currentGamepad2.copy(g2);
        leftStick = new Vector2d(currentGamepad1.left_stick_x, currentGamepad1.left_stick_y);
        rightStick = new Vector2d(currentGamepad1.right_stick_x, currentGamepad1.right_stick_y);
    }

    public Vector2d getLeftStick() {
        return leftStick;
    }

    public Vector2d getRightStick() {
        return rightStick;
    }

}
