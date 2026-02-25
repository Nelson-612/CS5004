public class EmptyNode implements StringList {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(String s) {
    return false;
  }

  @Override
  public boolean containsAll(StringList other) {
    // All elements of this list (none) are in other → true
    return true;
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public StringList filterLargerThan(int maxLen) {
    return this;
  }

  @Override
  public StringList removeDuplicates() {
    return this;
  }

  @Override
  public String toString() {
    return "[]";
  }
}