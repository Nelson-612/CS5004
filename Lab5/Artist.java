import java.util.Arrays;

public abstract class Artist {
  private final Name name;          // required: first + last inside Name
  private final int age;            // required range [0, 128]
  private final String[] genres;    // defensive copy
  private String[] awards;          // grows when receiveAward is called

  public Artist(Name name, int age, String[] genres, String[] awards) {
    if (name == null) {
      throw new IllegalArgumentException("name cannot be null");
    }
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("age must be in range [0, 128]");
    }

    this.name = name;
    this.age = age;

    // null-safe + defensive copy
    this.genres = (genres == null) ? new String[0] : Arrays.copyOf(genres, genres.length);
    this.awards = (awards == null) ? new String[0] : Arrays.copyOf(awards, awards.length);
  }

  public Name getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  // Return copies to avoid privacy leaks
  public String[] getGenres() {
    return Arrays.copyOf(genres, genres.length);
  }

  public String[] getAwards() {
    return Arrays.copyOf(awards, awards.length);
  }

  // Required behavior: add award to current awards array
  public void receiveAward(String award) {
    if (award == null || award.isBlank()) {
      throw new IllegalArgumentException("award cannot be null/blank");
    }

    String[] next = Arrays.copyOf(awards, awards.length + 1);
    next[next.length - 1] = award;
    awards = next;
  }
}

