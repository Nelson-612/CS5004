import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTest {
  @Test
  public void testConstructorDuplicatePoints() {
    // A = B (Throw)
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 0, 0, 1, 1));

    // B = C (Throw)
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 2, 2, 2, 2));
  }

  @Test
  public void testConstructorValidPoints() {
    assertDoesNotThrow(() -> new Triangle(0, 0, 3, 0, 0, 4));

    Triangle t = new Triangle(1, 1, 2, 3, 4, 2);
    assertNotNull(t);
  }

  @Test
  public void testAreaNormalTriangle() {
    Triangle t = new Triangle(0, 0, 3, 0,0 ,4);

    assertEquals(6.0, t.area(), 1e-6);
    assertTrue(t.area() > 0); // check area is positive
  }

  @Test
  public void testAreaCollinearTriangle() {
    Triangle t = new Triangle(0, 0, 1, 1, 2,2);
    assertEquals(0.0, t.area(), 1e-6);
    assertTrue(t.area() >= 0);
  }

  @Test
  public void testPerimeterNormalTriangle() {
    Triangle t = new Triangle(0,0,3,0,0,4);
    assertEquals(12.0, t.perimeter(), 1e-6);
    assertTrue(t.perimeter() > 0);
  }

  @Test
  public void testResize() {
    Triangle t = new Triangle(0,0,3,0,0,4);
    Shape bigger = t.resize(4.0);
    assertEquals(t.area() * 4.0, bigger.area(), 1e-6);
    assertEquals(t.perimeter() * 2.0, bigger.perimeter(), 1e-6);
  }

  @Test
  public void testToString() {
    Triangle t = new Triangle(0, 0, 3, 0, 0,4);
    String s = t.toString();
    assertTrue(s.contains("Triangle"));
    assertTrue(s.contains("0.000"));
  }
}

