import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CircleTest {
  @Test
  public void testArea() {
    Circle c = new Circle(0, 0, 5);
    assertEquals(Math.PI *25,  c.area(), 1e-6);
    assertTrue(c.area() >0);
  }

  @Test
  public void testPerimeter() {
    Circle c = new Circle(0, 0, 5);
    assertEquals(2 * Math.PI * 5, c.perimeter(), 1e-6);
    assertTrue(c.perimeter() > 0);
  }

  @Test
  public void testResize() {
    Circle c = new Circle(0, 0, 5);
    Circle bigger = (Circle) c.resize(4.0);
    assertEquals(c.area() * 4.0, bigger.area(), 1e-6);
    assertEquals(c.perimeter() * 2.0, bigger.perimeter(), 1e-6);
  }

  @Test
  public void testToString() {
    Circle c = new Circle(0, 0, 5);
    String s = c.toString();
    assertTrue(s.contains("Circle"));
    assertTrue(s.contains("0.000"));
  }
}
