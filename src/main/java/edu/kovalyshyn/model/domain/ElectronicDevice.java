package edu.kovalyshyn.model.domain;

public abstract class ElectronicDevice {
  private int power;
  private boolean isOn;
  private int workHours;

  public ElectronicDevice(int power, int workHours) {//Random.nextInt(24)
    this.power = power;
    this.isOn = false;
    this.workHours = workHours;
  }

  public int getPower() {
    return power;
  }

  public int getWorkHours(){return workHours;}

  public void setPower(int power) {
    this.power = power;
  }

  public boolean isOn() {
    return isOn;
  }

  public void setOn(boolean on) {
    isOn = on;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        " - power is " + power + "W;"+
         " turned On: "+isOn+" ;";

  }
}


