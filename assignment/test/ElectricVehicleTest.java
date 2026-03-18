import org.junit.Test;
import static org.junit.Assert.*;

public class ElectricVehicleTest {

  @Test // 1. Constructor with valid input
  public void testConstructorWithValidValues() {
    ElectricVehicle ev = new ElectricVehicle("Tesla", 100.0, 0.5, 3.0);

    assertEquals("Tesla", ev.getName());
    assertEquals(100.0, ev.getBatterySize(), 0.0001);
    assertEquals(0.5, ev.getStateOfCharge(), 0.0001);
    assertEquals(3.0, ev.getEfficiency(), 0.0001);
  }

  @Test // 2. Battery size clamps low
  public void testBatteryClampsLow() {
    ElectricVehicle ev = new ElectricVehicle("Test", 5.0 , 0.5, 3.0);
    assertEquals(10.0, ev.getBatterySize(), 0.0001);
  }

  @Test // 3. Battery clamps high
  public void testBatteryClampsHigh() {
    ElectricVehicle ev = new ElectricVehicle("Test", 200.0, 0.5, 3.0);
    assertEquals(150.0, ev.getBatterySize(), 0.0001);
  }

  @Test // 4. Efficiency clamps low
  public void testEfficiencyClampsLow() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 0.1);
    assertEquals(0.5, ev.getEfficiency(), 0.0001);
  }

  @Test // 5. Efficiency clamps high
  public void testEfficiencyClampsHigh() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 10.0);
    assertEquals(4.5, ev.getEfficiency(), 0.0001);
  }

  @Test // 6. SoC clamps low
  public void testStateOfChargeClampsLow() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.05, 3.0);
    assertEquals(0.15, ev.getStateOfCharge(), 0.0001);
  }

  @Test // 7. SoC clamps high
  public void testStateOfChargeClampsHigh() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 2.0, 3.0);
    assertEquals(1.0, ev.getStateOfCharge(), 0.0001);
  }

  @Test // 8. Name null -> becomes "unknown EV"
  public void testNameNullBecomesUnknown() {
    ElectricVehicle ev = new ElectricVehicle(null, 100.0, 0.5, 3.0);
    assertEquals("unknown EV", ev.getName());
  }

  @Test // 9. Name empty -> becomes "unknown EV"
  public void testNameEmptyBecomesUnknown() {
    ElectricVehicle ev = new ElectricVehicle("", 100.0, 0.5, 3.0);
    assertEquals("unknown EV", ev.getName());
  }

  @Test // 10. Ideal temp keeps efficiency at 100%
  public void idealTempKeepsEfficiency() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 3.0);
    ev.updateEfficiency(70.0); // between 65 and 77
    assertEquals(3.0, ev.getEfficiency(), 0.0001);
  }

  @Test // 11. Hot temp reduces efficiency to 85% of default
  public void updateEfficiencyReducesEfficiencyToEightyFivePercentInHotTemperatures() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 4.0);
    ev.updateEfficiency(90.0); // > 77
    assertEquals(4.0 * 0.85, ev.getEfficiency(), 0.0001);
  }

  @Test // 12. Cold temp reduces efficiency by 1% per degree below 65
  public void coldTempReducesEfficiency() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 4.0);
    ev.updateEfficiency(60.0); // 5 degrees below 65 -> 5% loss
    assertEquals(4.0 * 0.95, ev.getEfficiency(), 0.0001);
  }

  @Test // 13. Extreme cold caps efficiency loss at 50%
  public void extremeColdCapsLoss() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 4.0);
    ev.updateEfficiency(0.0); // very cold -> should cap at 50% loss
    assertEquals(4.0 * 0.5, ev.getEfficiency(), 0.0001);
  }

  @Test // 14. setStateOfCharge clamps low input
  public void testSetStateOfChargeClampsLow() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 3.0);
    ev.setStateOfCharge(0.05);
    assertEquals(0.15, ev.getStateOfCharge(), 0.0001);
  }

  @Test // 15. setStateOfCharge clamps high input
  public void testSetStateOfChargeClampsHigh() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 3.0);
    ev.setStateOfCharge(2.0);
    assertEquals(1.0, ev.getStateOfCharge(), 0.0001);
  }

  @Test // 16. setStateOfCharge keeps valid value unchanged
  public void testSetStateOfChargeKeepsValid() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 3.0);
    ev.setStateOfCharge(0.8);
    assertEquals(0.8, ev.getStateOfCharge(), 0.0001);
  }

  @Test // 17. range() uses currentEfficiency * SoC * batterySize
  public void testRangeCalculation() {
    ElectricVehicle ev = new ElectricVehicle("Test", 100.0, 0.5, 3.0);
    double expected = 3.0 * 0.5 * 100.0; // 150.0
    assertEquals(expected, ev.range(), 0.0001);
  }

  @Test // 18. toString contains name, SOC% and range
  public void testToStringFormat() {
    ElectricVehicle ev = new ElectricVehicle("Ford MachE", 100.0, 0.5, 3.0);
    String s = ev.toString();

    assertTrue(s.contains("Ford MachE"));    // name
    assertTrue(s.contains("50.0%"));         // SOC as percent
    assertTrue(s.contains("150.0"));         // range with 1 decimal
    assertTrue(s.contains("SOC"));           // label SOC
    assertTrue(s.contains("Range (miles):")); // range label
  }
}