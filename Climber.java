package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;

public class Climber {

  Solenoid level2ClimberUp;
  Solenoid level2ClimberDown;

  CANSparkMax level3ClimberMotor = new CANSparkMax(8, MotorType.kBrushless);

  boolean isLevel2ClimberDown = true;

  public void climberInit() {
    level2ClimberUp = Robot.ph.makeSolenoid(13);
    level2ClimberDown = Robot.ph.makeSolenoid(11);
  }

  public void climberTeleop() {

    if (Constants.xbox.getRawButtonPressed(7)) {
      if (isLevel2ClimberDown) {
        level2ClimberDown.set(false);
        level2ClimberUp.set(true);
        isLevel2ClimberDown = false;
      } else {
        level2ClimberUp.set(false);
        level2ClimberDown.set(true);
        isLevel2ClimberDown = true;
      }
    }

    if (Constants.stick.getRawButton(5)) {
      level3ClimberMotor.set(0.2);
    } else if (Constants.stick.getRawButton(6)) {
      level3ClimberMotor.set(-0.2);
    } else {
      level3ClimberMotor.set(0.0);
    }
  }

}