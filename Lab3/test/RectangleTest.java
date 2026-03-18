import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {

  @Test
  public void testArea() {
  Rectangle r = new Rectangle(0, 0, 3, 4);
  assertEquals(12.0,r.area(), 1e-6);
  assertTrue(r.area() > 0);
}

  @Test
  public void testPerimeter() {
    Rectangle r = new Rectangle(0, 0, 3, 4);
    assertEquals(14.0, r.perimeter(), 1e-6);
    assertTrue(r.perimeter() > 0);
  }

  @Test
  public void testResize() {
    Rectangle r = new Rectangle(0, 0, 3, 4);
    Rectangle bigger = (Rectangle) r.resize(4.0);
    assertEquals(r.area() * 4, bigger.area(), 1e-6);
    assertEquals(r.perimeter() * 2.0, bigger.perimeter(), 1e-6);
  }
  @Test
  public void testToString() {
    Rectangle r = new Rectangle(0,0,3,4);
    String s = r.toString();

    assertTrue(s.contains("Rectangle"));
    assertTrue(s.contains("0.000"));
  }
}
