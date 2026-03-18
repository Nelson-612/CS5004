import java.util.Arrays;

public abstract class VisualArtist extends Artist {

  private final String[] exhibits;

  public VisualArtist(Name name, int age,
      String[] genres, String[] awards,
      String[] exhibits) {

    super(name, age, genres, awards);

    this.exhibits = (exhibits == null)
        ? new String[0] : Arrays.copyOf(exhibits, exhibits.length);
  }

  public String[] getExhibits() {
    return Arrays.copyOf(exhibits, exhibits.length);
  }
}