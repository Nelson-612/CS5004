public class Book {
  private String title;
  private String author;
  private int pages;

  /**
   * Constructs a new Book with the given title, author, and number of pages.
   *
   * @param title  the title of the book
   * @param author the author of the book
   * @param pages  the number of pages in the book
   */

  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }
  /**
   * @return the title
   */
  public String getTitle() { return this.title; }
  /**
   * @return the author
   */
  public String getAuthor() { return this.author; }
  /**
   * @return the pages
   */
  public int getPages() { return this.pages; }
}
