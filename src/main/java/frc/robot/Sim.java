//Created by Spectrum3847
package frc.robot;

import frc.lib.sim.PhysicsSim;

public class Sim {
    public static void intialization (){
        PhysicsSim.getInstance().addTalonFX(Robot.intake.motor, 0.75, 5100.0, false);
        PhysicsSim.getInstance().addTalonFX(Robot.indexer.motor, 0.75, 5100.0, false);
        PhysicsSim.getInstance().addTalonFX(Robot.tower.motorFront, 0.75, 5100.0, false);
        PhysicsSim.getInstance().addTalonFX(Robot.tower.motorRear, 0.75, 5100.0, false);
        PhysicsSim.getInstance().addTalonFX(Robot.launcher.motorLeft, 0.75, 5100.0, false);
        PhysicsSim.getInstance().addTalonFX(Robot.launcher.motorRight, 0.75, 5100.0, false);
    }
}
