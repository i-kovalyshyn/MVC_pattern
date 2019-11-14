package edu.kovalyshyn.controller;

import edu.kovalyshyn.model.BusinessLogic;
import edu.kovalyshyn.model.domain.ElectronicDevice;
import edu.kovalyshyn.model.Model;
import java.util.List;

public class ControllerImpl implements Controller {

  private Model model;

  public ControllerImpl(){
    model=new BusinessLogic();
  }

  @Override
  public List<ElectronicDevice> turnedOnAppliance() {
    return model.turnedOnAppliance();
  }

  @Override
  public long calculateElectricityConsumed() {
    return model.calculateElectricityConsumed();
  }

  @Override
  public void sortedByElectricitiConsumed() {
    model.sortedByElectricitiConsumed();
  }

  @Override
  public List<ElectronicDevice> findByElectricityConsume(int from, int to) {
    return model.findByElectricityConsume(from, to);
  }

  @Override
  public void printDevices() {
    model.printDevices();
  }


}


