package org.rowlandhall;

import com.qualcomm.robotcore.hardware.Gamepad;

public interface Subsystem {
    void controllerUpdate(Gamepad gp1, Gamepad gp2);
}
