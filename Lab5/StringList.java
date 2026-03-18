public interface StringList {
  boolean isEmpty();
  int size();
  boolean contains(String s);
  boolean containsAll(StringList other);
  boolean hasDuplicates();
  StringList filterLargerThan(int maxLen);
  StringList removeDuplicates();

  @Override
  String toString();
}