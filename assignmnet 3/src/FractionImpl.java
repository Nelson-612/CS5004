/**
 * Concrete implementation of Fraction.
 *
 * <p>Fractions are always kept in normalized form:
 * denominator is positive, and numerator/denominator are reduced by gcd.</p>
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a FractionImpl with the given numerator and denominator.
   *
   * <p>The denominator must be strictly positive. The resulting fraction is
   * normalized to simplest form, with any sign stored in the numerator.</p>
   *
   * @param numerator the numerator
   * @param denominator the denominator (must be > 0)
   * @throws IllegalArgumentException if denominator <= 0
   */
  public FractionImpl(int numerator, int denominator) {
    requirePositiveDenominator(denominator);
    this.numerator = numerator;
    this.denominator = denominator;
    normalize();
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    this.numerator = n;
    normalize();
  }

  @Override
  public void setDenominator(int d) {
    requirePositiveDenominator(d);
    this.denominator = d;
    normalize();
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  /**
   * Returns a string representation in simplest form: "n / d".
   *
   * @return a printable representation of this fraction
   */
  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new IllegalArgumentException("Cannot take reciprocal of zero");
    }
    // Constructor + normalize will ensure denominator stays positive.
    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Other fraction cannot be null");
    }

    int newNumerator =
        this.numerator * other.getDenominator()
            + other.getNumerator() * this.denominator;

    int newDenominator =
        this.denominator * other.getDenominator();

    return new FractionImpl(newNumerator, newDenominator);
  }

  @Override
  public int compareTo(Fraction other) {
    // Use long to avoid overflow in cross multiplication.
    long left = (long) this.numerator * other.getDenominator();
    long right = (long) other.getNumerator() * this.denominator;
    return Long.compare(left, right);
  }

  // ---- helpers ----

  private static void requirePositiveDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be positive");
    }
  }

  /**
   * Euclid's algorithm for greatest common divisor.
   */
  private static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * Normalizes the fraction into simplest form with denominator positive.
   *
   * <p>Also stores zero consistently as 0 / 1.</p>
   */
  private void normalize() {
    if (numerator == 0) {
      denominator = 1;
      return;
    }

    int g = gcd(numerator, denominator);
    numerator /= g;
    denominator /= g;

    // Defensive: should already be positive due to validation, but ensures sign convention.
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
  }
}