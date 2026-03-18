import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book book1;
  private Book book2;
  private Book book3;

  @BeforeEach
  void setUp() {
    this.book1 = new Book("Get", "Nelson", 100);
    this.book2 = new Book("Well", "Peter",150);
    this.book3 = new Book("Soon", "Will",200);
  }

  @Test
  void getTitle() {
    Assertions.assertEquals("Get", this.book1.getTitle());
    Assertions.assertEquals("Well", this.book2.getTitle());
    Assertions.assertEquals("Soon", this.book3.getTitle());
  }

  @Test
  void getAuthor() {
    Assertions.assertEquals("Nelson", this.book1.getAuthor());
    Assertions.assertEquals("Peter", this.book2.getAuthor());
    Assertions.assertEquals("Will", this.book3.getAuthor());

  }

  @Test
  void getPages() {
    Assertions.assertEquals(100, this.book1.getPages());
    Assertions.assertEquals(150, this.book1.getPages());
    Assertions.assertEquals(200, this.book1.getPages());
  }
}