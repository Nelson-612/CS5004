import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {
  Book b1 = new Book("Title", "Author", 1990, 10);
  Book b2= new Book("Title", "Author", 2010, 20);
  Book b3 = new Book("Title", "Author", 2000, 30);

  IListOfBooks empty = new EmptyNode();
  IListOfBooks one = new ElementNode(b1, empty);
  IListOfBooks two = new ElementNode(b1,
      new ElementNode(b2, empty));

  @Test
  void testCount() {
    assertEquals(0, empty.count());
    assertEquals(1, one.count());
    assertEquals(2, two.count());
  }

  @Test
  void testTotalPrice() {
    assertEquals(0, empty.totalPrice(), 0.001);
    assertEquals(10, one.totalPrice(), 0.001);
    assertEquals(30, two.totalPrice(), 0.001);
  }

  @Test
  void testAllBefore() {
    assertEquals(0, empty.allBefore(2000).count());
    assertEquals(1, one.allBefore(2010).count());
    assertEquals(1, two.allBefore(2010).count());
  }

  @Test
  void testAddAtEnd() {
    assertEquals(1, empty.addAtEnd(b1).count());
    assertEquals(3, two.addAtEnd(b3).count());
  }

  @Test
  void testToString() {
    assertEquals("[]", empty.toString());
    assertEquals("[" + b1 + "]", one.toString());
    assertEquals("["+b1+", "+b2+"]", two.toString());
  }
}
