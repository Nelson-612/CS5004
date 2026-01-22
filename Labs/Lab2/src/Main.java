public class Main {
  public static void main(String[] args) {

    // Create a few Shoe objects
    Shoe shoe1 = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.ADIDAS, 10.5);
    Shoe shoe2 = new Shoe(Kind.BOOT, Color.RED, Brand.NIKE, 8.0);

    // Print results
    System.out.println(shoe1);
    System.out.println(shoe2);

    // Optional: test exception behavior
    try {
      Shoe badShoe = new Shoe(Kind.DRESS, Color.BLACK, Brand.NIKE, 9.0);
    } catch (IllegalArgumentException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }
  }
}
