/**
 * Represents a Shoe with a kind, color, brand, and size.
 * This class enforces a business rule: NIKE does not sell dress shoes.
 */
public class Shoe {

  private Kind kind;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Constructs a Shoe object.
   *
   * @param kind  the type of shoe (e.g. SNEAKER, DRESS, BOOT, SANDAL)
   * @param color the shoe color
   * @param brand the shoe brand
   * @param size  the numeric shoe size
   * @throws IllegalArgumentException if brand is NIKE and kind is DRESS
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("Nike does not sell dress shoes.");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * @return the kind of this shoe
   */
  public Kind getKind() {
    return this.kind;
  }

  /**
   * @return the color of this shoe
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * @return the brand of this shoe
   */
  public Brand getBrand() {
    return this.brand;
  }

  /**
   * @return the size of this shoe
   */
  public double getSize() {
    return this.size;
  }

  /**
   * Returns a formatted String describing this Shoe object,
   * including brand, color, kind, and size. Colors not explicitly
   * handled in the switch default to "Neutral".
   *
   * @return a summary of this Shoe
   */
  @Override
  public String toString() {
    String colorString;

    switch (this.color) {
      case BLACK:
        colorString = "Black";
        break;
      case RED:
        colorString = "Red";
        break;
      default:
        colorString = "Neutral";
    }

    return this.brand + " " + colorString + " " + this.kind + " (size " + this.size + ")";
  }
}
