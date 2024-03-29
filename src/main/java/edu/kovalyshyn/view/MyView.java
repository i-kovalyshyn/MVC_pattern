package edu.kovalyshyn.view;

import edu.kovalyshyn.controller.Controller;
import edu.kovalyshyn.controller.ControllerImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {

  private Controller controller;
  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private static Scanner input = new Scanner(System.in);

  public MyView() {
    controller = new ControllerImpl();
    menu = new LinkedHashMap<>();
    menu.put("1", " 1 - print all electronics  appliances at home");
    menu.put("2", " 2 - turned on some appliances");
    menu.put("3", " 3 - calculation of consumed electricity");
    menu.put("4", " 4 - sort by Electricity Consumed");
    menu.put("5", " 5 - find  electronic appliance by consumed electricity");
    menu.put("Q", " Q - EXIT");

    methodsMenu = new LinkedHashMap<>();
    methodsMenu.put("1", this::pressButton1);
    methodsMenu.put("2", this::pressButton2);
    methodsMenu.put("3", this::pressButton3);
    methodsMenu.put("4", this::pressButton4);
    methodsMenu.put("5", this::pressButton5);
  }

  private void pressButton1() {
    System.out.println("All electronics  appliances at home: +\n-------------------------");
    controller.printDevices();
  }

  private void pressButton2() {
    controller.turnedOnAppliance().forEach(System.out::println);
  }

  private void pressButton3() {
    System.out.println("calculation of consumed electricity is: " +
        controller.calculateElectricityConsumed() + " W/h");

  }

  private void pressButton4() {

    controller.sortedByElectricitiConsumed();
  }

  private void pressButton5() {
    System.out.println("Show electronic appliance by consumed electricity:");
    System.out.println("please input range of electronics power from min");
    Scanner scanner = new Scanner(System.in);
    int from = scanner.nextInt();
    System.out.println("to max power in W");
    int to = scanner.nextInt();

    controller.findByElectricityConsume(from,to).forEach(System.out::println);
  }

  private void outputMenu() {
    System.out.println("\n MENU:");
    for (String str : menu.values()) {
      System.out.println(str);
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();
      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception e) {
      }
    } while (!keyMenu.equals("Q"));
  }
}
