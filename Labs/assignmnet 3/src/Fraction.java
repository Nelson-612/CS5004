/**
 * Represents a mathematical fraction with an integer numerator and a strictly
 * positive integer denominator.
 *
 * <p>Implementations must maintain the invariant that denominators are always
 * positive. Fractions should be represented in simplest (reduced) form.</p>
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator
   */
  int getNumerator();

  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator (always positive)
   */
  int getDenominator();

  /**
   * Sets the numerator of this fraction.
   *
   * <p>The fraction should remain normalized (simplified) after this call.</p>
   *
   * @param n the new numerator
   */
  void setNumerator(int n);

  /**
   * Sets the denominator of this fraction.
   *
   * <p>The denominator must remain strictly positive. The fraction should
   * remain normalized (simplified) after this call.</p>
   *
   * @param d the new denominator
   * @throws IllegalArgumentException if d <= 0
   */
  void setDenominator(int d);

  /**
   * Returns the numeric (decimal) value of this fraction.
   *
   * @return the fraction value as a double
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction.
   *
   * @return a new Fraction that is the reciprocal of this one
   * @throws IllegalArgumentException if the numerator is 0
   */
  Fraction reciprocal();

  /**
   * Returns the sum of this fraction and another fraction.
   *
   * @param other the fraction to add
   * @return a new Fraction representing the sum, in simplest form
   * @throws IllegalArgumentException if other is null
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to another fraction numerically.
   *
   * @param other the fraction to compare against
   * @return a negative integer if this < other, positive if this > other, and 0 otherwise
   */
  @Override
  int compareTo(Fraction other);
}