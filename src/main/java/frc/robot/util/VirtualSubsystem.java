// Copyright (c) 2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by an MIT-style
// license that can be found in the LICENSE file at
// the root directory of this project.

package frc.robot.util;

import java.util.ArrayList;
import java.util.List;

/** Represents a subsystem unit that requires a periodic callback but not a hardware mutex. */
public abstract class VirtualSubsystem {
  private static List<VirtualSubsystem> subsystems = new ArrayList<>();

  protected VirtualSubsystem() {
    subsystems.add(this);
  }

  /** Calls {@link #periodic()} on all virtual subsystems. */
  public static void periodicAll() {
    for (var subsystem : subsystems) {
      subsystem.periodic();
    }
  }

  /** This method is called periodically once per loop cycle. */
  public abstract void periodic();
}