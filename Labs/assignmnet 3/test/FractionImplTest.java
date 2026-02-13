import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionImplTest {

  @Test
  void testConstructor() {
    Fraction f = new FractionImpl(1, 2);
    assertEquals(1, f.getNumerator());
    assertEquals(2, f.getDenominator());
  }

  @Test
  void testNormalization() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals(2, f.getNumerator());
    assertEquals(1, f.getDenominator());

    Fraction z = new FractionImpl(0, 5);
    assertEquals(0, z.getNumerator());
    assertEquals(1, z.getDenominator());
  }

  @Test
  void testNegativeNormalization() {
    Fraction f = new FractionImpl(-2, 4);
    assertEquals(-1, f.getNumerator());
    assertEquals(2, f.getDenominator());
    assertEquals("-1 / 2", f.toString());
  }

  @Test
  void testConstructorExceptions() {
    assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(1, 0));

    assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(1, -2));
  }

  @Test
  void testAdd() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(1, 2);
    Fraction result = a.add(b);
    assertEquals(1, result.getNumerator());
    assertEquals(1, result.getDenominator());

    Fraction c = new FractionImpl(1, 2);
    Fraction d = new FractionImpl(1, 3);
    Fraction result2 = c.add(d);
    assertEquals(5, result2.getNumerator());
    assertEquals(6, result2.getDenominator());
  }

  @Test
  void testAddWithNegatives() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(-1, 3);
    Fraction result = a.add(b);
    assertEquals(1, result.getNumerator());
    assertEquals(6, result.getDenominator());
  }

  @Test
  void testAddNullThrows() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class,
        () -> a.add(null));
  }

  @Test
  void testReciprocal() {
    Fraction f = new FractionImpl(2, 3);
    Fraction r = f.reciprocal();
    assertEquals(3, r.getNumerator());
    assertEquals(2, r.getDenominator());

    Fraction zero = new FractionImpl(0, 1);
    assertThrows(IllegalArgumentException.class,
        () -> zero.reciprocal());
  }

  @Test
  void testCompareTo() {
    Fraction a = new FractionImpl(1, 3);
    Fraction b = new FractionImpl(1, 2);
    Fraction c = new FractionImpl(2, 3);
    Fraction d = new FractionImpl(2, 4);

    assertTrue(a.compareTo(b) < 0);
    assertTrue(c.compareTo(b) > 0);
    assertEquals(0, b.compareTo(d));
  }

  @Test
  void testToDouble() {
    Fraction a = new FractionImpl(1, 2);
    assertEquals(0.5, a.toDouble(), 0.001);
  }

  @Test
  void testSetterBehavior() {
    Fraction f = new FractionImpl(1, 2);
    f.setNumerator(2); // 2/2 -> 1/1 after normalize
    assertEquals(1, f.getNumerator());
    assertEquals(1, f.getDenominator());

    Fraction valid = new FractionImpl(1, 2);
    valid.setDenominator(4);
    assertEquals(1, valid.getNumerator());
    assertEquals(4, valid.getDenominator());

    Fraction bad1 = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class,
        () -> bad1.setDenominator(0));

    Fraction bad2 = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class,
        () -> bad2.setDenominator(-1));
  }

  @Test
  void testToString() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals("2 / 1", f.toString());
  }
}