package edu.kovalyshyn.model;

import edu.kovalyshyn.model.domain.CoffeeMaker;
import edu.kovalyshyn.model.domain.ElectronicDevice;
import edu.kovalyshyn.model.domain.Kettle;
import edu.kovalyshyn.model.domain.Laptop;
import edu.kovalyshyn.model.domain.Microvawe;
import edu.kovalyshyn.model.domain.MultiCooker;
import edu.kovalyshyn.model.domain.PC;
import edu.kovalyshyn.model.domain.Refrigerator;
import edu.kovalyshyn.model.domain.Tv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BusinessLogic implements Model {

  private List<ElectronicDevice> devices;

  public static final Random RANDOM = new Random();

  public BusinessLogic() {
    devices = new LinkedList<>();
    /**
     *  receive list of Electronic devices with random working time in hours per day
     */
    devices.addAll(Arrays.asList(
        new Microvawe(RANDOM.nextInt(25)),
        new CoffeeMaker(RANDOM.nextInt(25)),
        new Kettle(RANDOM.nextInt(25)),
        new Laptop(RANDOM.nextInt(25)),
        new MultiCooker(RANDOM.nextInt(25)),
        new PC(RANDOM.nextInt(25)),
        new Refrigerator(RANDOM.nextInt(25)),
        new Tv(RANDOM.nextInt(25)))
    );
  }

  @Override
  public void printDevices() {

    devices.forEach(System.out::println);
  }

  @Override
  public List<ElectronicDevice> turnedOnAppliance() {
    return devices.stream()
        .peek(index -> devices.get(RANDOM.nextInt(devices.size())).setOn(true))
        .filter(ElectronicDevice::isOn)
        .collect(Collectors.toList());
  }

  @Override
  public long calculateElectricityConsumed() {
    int sumOfPower = devices.stream()
        .peek(index -> devices.get(RANDOM.nextInt(devices.size())).setOn(true))
        .filter(ElectronicDevice::isOn)
        .map(ElectronicDevice::getPower)
        .reduce(Integer::sum)
        .orElse(0);
    int sumOfWorkHours = devices.stream()
        .filter(ElectronicDevice::isOn)
        .mapToInt(ElectronicDevice::getWorkHours).sum();

    return sumOfPower*sumOfWorkHours;

  }

  @Override
  public void sortedByElectricitiConsumed() {
    devices.sort((Comparator.comparing(ElectronicDevice::getPower)));
    devices.forEach(System.out::println);

  }

  @Override
  public List<ElectronicDevice> findByElectricityConsume(int from, int to) {
    return devices.stream()
        .filter(devices -> devices.getPower() >= from)
        .filter(devices -> devices.getPower() <= to)
        .collect(Collectors.toList());

  }
}
