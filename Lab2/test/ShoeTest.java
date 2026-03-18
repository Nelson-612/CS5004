import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoeTest {

  @Test
  void constructorAndGetters_validShoe() {
    Shoe shoe = new Shoe(Kind.BOOT, Color.BLACK, Brand.NIKE, 9.0);

    // These assertions test both the constructor and all four getters
    assertEquals(Kind.BOOT, shoe.getKind());
    assertEquals(Color.BLACK, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(9.0, shoe.getSize());
  }

  @Test
  void constructor_throwsOnNikeDress() {
    // This tests the NIKE + DRESS rule using a lambda expression
    assertThrows(IllegalArgumentException.class, () -> {
      new Shoe(Kind.DRESS, Color.BLACK, Brand.NIKE, 10.0);
    });
  }

  @Test
  void toString_usesSpecificColorName() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.RED, Brand.ADIDAS, 8.0);

    String expected = "ADIDAS Red SNEAKER (size 8.0)";
    assertEquals(expected, shoe.toString());
  }

  @Test
  void toString_usesDefaultForOtherColors() {
    // Use a color that is NOT BLACK or RED to trigger the default branch
    Shoe shoe = new Shoe(Kind.SANDAL, Color.BROWN, Brand.VANS, 7.5);

    String expected = "VANS Neutral SANDAL (size 7.5)";
    assertEquals(expected, shoe.toString());
  }
}

