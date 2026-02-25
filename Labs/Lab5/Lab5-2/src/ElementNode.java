public class ElementNode implements StringList {
  private final String first;
  private final StringList rest;

  public ElementNode(String first, StringList rest) {
    if (first == null) throw new IllegalArgumentException("String value cannot be null");
    if (rest == null) throw new IllegalArgumentException("rest cannot be null");
    this.first = first;
    this.rest = rest;
  }

  public String getFirst() {
    return first;
  }

  public StringList getRest() {
    return rest;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + rest.size();
  }

  @Override
  public boolean contains(String s) {
    if (s == null) return false;
    return first.equals(s) || rest.contains(s);
  }

  @Override
  public boolean containsAll(StringList other) {
    // all elements of THIS must be in other
    return other != null && other.contains(first) && rest.containsAll(other);
  }

  @Override
  public StringList filterLargerThan(int maxLen) {
    StringList filteredRest = rest.filterLargerThan(maxLen);
    if (first.length() > maxLen) {
      return filteredRest; // drop first
    }
    return new ElementNode(first, filteredRest);
  }

  @Override
  public boolean hasDuplicates() {
    return rest.contains(first) || rest.hasDuplicates();
  }

  @Override
  public StringList removeDuplicates() {
    StringList restNoFirst = removeAll(rest, first);
    return new ElementNode(first, restNoFirst.removeDuplicates());
  }

  private static StringList removeAll(StringList list, String target) {
    if (list.isEmpty()) return list;

    ElementNode node = (ElementNode) list; // safe if only ElementNode/EmptyNode exist
    if (node.first.equals(target)) {
      return removeAll(node.rest, target);
    }
    return new ElementNode(node.first, removeAll(node.rest, target));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(first);
    StringList cur = rest;
    while (!cur.isEmpty()) {
      ElementNode n = (ElementNode) cur;
      sb.append(", ").append(n.first);
      cur = n.rest;
    }
    sb.append("]");
    return sb.toString();
  }
}