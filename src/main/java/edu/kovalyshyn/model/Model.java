package edu.kovalyshyn.model;

import edu.kovalyshyn.model.domain.ElectronicDevice;
import java.util.List;

public interface Model {

  List<ElectronicDevice> turnedOnAppliance();

  long calculateElectricityConsumed();

  void sortedByElectricitiConsumed();

  List<ElectronicDevice> findByElectricityConsume(int from, int to);

  public void printDevices();


}
