public class Triangle  extends AbstractShape {
  // other 2 vertices of triangle
  private Point2D p2;
  private Point2D p3;

  // using 3 (x,y) point
  // first point (x1, y1) = reference point
  public Triangle (double x1, double y1, double x2, double y2, double x3, double y3){

    // Store first point as reference point in AbstractShape
    super(new Point2D(x1, y1));

    // Create 2 points
    Point2D point2 = new Point2D(x2, y2);
    Point2D point3 = new Point2D(x3, y3);

    // Validate that all three point are distinct
    boolean abSame = reference.getX() == point2.getX()
        && reference.getY() == point2.getY();

    boolean acSame = reference.getX() == point3.getX()
        && reference.getY() == point3.getY();

    boolean bcSame = point2.getX() == point3.getX()
        && point2.getY() == point3.getY();

    if (abSame || acSame || bcSame) {
      throw new IllegalArgumentException("Triangle points must be distinct");
    }
    this.p2 = point2;
    this.p3 = point3;
  }

  // distance between 2 points
  private double distance(Point2D a, Point2D b){
    double dx = a.getX() - b.getX();
    double dy = a.getY() - b.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  // compute area
  @Override
  public double area() {
    double a = distance(reference, p2); // length of 3 sides
    double b = distance(p2, p3);
    double c = distance(p3, reference);

    // Semi-perimeter
    double s = (a + b + c)/ 2.0;

    return Math.sqrt(s * (s-a) * (s -b) * (s-c));
  }

  // Compute perimeter
  @Override
  public double perimeter() {
    double a = distance(reference, p2);
    double b = distance(p2, p3);
    double c = distance(p3, reference);

    return a+b+c;
  }

  @Override
  public Shape resize(double factor) {
    double scale = Math.sqrt(factor);

    // new location for p2
    Point2D newP2 = new Point2D(
        reference.getX() + scale *(p2.getX() - reference.getX()),
        reference.getY() + scale * (p2.getY() - reference.getY())
    );

    // new location for p3
    Point2D newP3 = new Point2D(
        reference.getX() + scale *(p3.getX() - reference.getX()),
        reference.getY() + scale * (p3.getY()- reference.getY())
    );

    // return a new Triangle with resized points
    return new Triangle(
        reference.getX(), reference.getY(),
        newP2.getX(), newP2.getY(),
        newP3.getX(), newP3.getY()
    );
  }

  public String toString() {
    return String.format(
        "Triangle: (%.3f, %.3f), (%.3f, %.3f), (%.3f, %.3f)",
        reference.getX(), reference.getY(),
        p2.getX(), p2.getY(),
        p3.getX(), p3.getY());
  }

}

