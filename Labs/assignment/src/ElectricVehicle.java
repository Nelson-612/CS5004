public class ElectricVehicle {

  // ---- Fields ----
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private double defaultEfficiency;

  // ---- Constructor ----
  public ElectricVehicle(String name, double batterySize, double stateOfCharge, double defaultEfficiency) {
    if (name == null || name.isEmpty()) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    if (batterySize < 10.0){
      this.batterySize = 10.0;
    } else if (batterySize > 150.0){
      this.batterySize = 150.0;
    } else {
      this.batterySize = batterySize;
    }

    if (defaultEfficiency < 0.5){
      this.defaultEfficiency = 0.5;
    } else if (defaultEfficiency > 4.5){
      this.defaultEfficiency = 4.5;
    } else {
      this.defaultEfficiency = defaultEfficiency;
    }
    this.currentEfficiency = this.defaultEfficiency;

    if (stateOfCharge < 0.15){
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge > 1.0) {
      this.stateOfCharge = 1.0;
    } else {
      this.stateOfCharge = stateOfCharge;
    }
  }

  public double range() {
    double result = currentEfficiency * stateOfCharge * batterySize;
    return result;
  }

  public void updateEfficiency(double currentTemp){
    double factor;

    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      factor = 1.0;
    } else if (currentTemp > 77.0) {
      factor = 0.85;
    } else {
      double delta = 65.0 - currentTemp;
      double loss = delta * 0.01;

      if (loss > 0.5) {
        loss = 0.5;
      }

      factor = 1.0 - loss;
    }

    this.currentEfficiency = this.defaultEfficiency * factor;
  }

  public void setStateOfCharge (double stateOfCharge) {
    if (stateOfCharge < 0.15) {
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge > 1.0) {
      this.stateOfCharge = 1.0;
    } else {
      this.stateOfCharge = stateOfCharge;
    }
  }

  public double getEfficiency() {
    return this.currentEfficiency;
  }

  public double getBatterySize() {
    return this.batterySize;
  }

  public double getStateOfCharge () {
    return this.stateOfCharge;
  }

  public String getName () {
    return this.name;
  }

  @Override
  public String toString() {
    double socPercent = this.stateOfCharge * 100;
    double rng = this.range();
    String socFormatted = String.format("%.1f", socPercent);
    String rngFormatted = String.format("%.1f", rng);

    return this.name + " SOC " + socFormatted + "% Range (miles): " + rngFormatted;
  }
}