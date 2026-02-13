public class ElementNode implements IListOfBooks{
  private Book first;
  private IListOfBooks rest;

  public ElementNode(Book book, IListOfBooks rest){
    this.first = book;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public float totalPrice() {
    return (first.getPrice() + rest.totalPrice());
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (first.before(year)) {
      return new ElementNode(first, rest.allBefore(year));
    } else {
      return rest.allBefore(year);
    }
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(first, rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    String restString = rest.toString();
    if (restString.equals("[]")) {
      return "[" + first + "]";
    } else {
      return "[" + first + ", " + restString.substring(1);
    }

  }
}
