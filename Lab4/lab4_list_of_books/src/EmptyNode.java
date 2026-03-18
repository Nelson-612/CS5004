public class EmptyNode implements IListOfBooks {
  public int count() {
    return 0;
  }

  public float totalPrice() {
    return 0;
  }

  public IListOfBooks allBefore(int year) {
    return this;
  }

  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, this);
  }

  public String toString() {
  return "[]";
  }
}
