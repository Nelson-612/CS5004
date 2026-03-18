public class main {
  public static void main(String[] args) {

    // Create an EV
    ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 82.0, 0.75, 3.7);

    // Print info
    System.out.println(ev);

    // Change temperature
    ev.updateEfficiency(90.0); // hot temperature reduces efficiency

    // Print again to see change
    System.out.println(ev);

    // Change SOC
    ev.setStateOfCharge(0.50);

    // Print again
    System.out.println(ev);
  }
}