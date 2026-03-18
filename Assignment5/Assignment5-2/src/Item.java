public abstract class Item {
  private String title;
  private int year;
  private Creator creator;

  public Item(String title, int year, Creator creator) {
    this.title = title;
    this.year = year;
    this.creator = creator;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public Creator getCreator() {
    return creator;
  }
}
