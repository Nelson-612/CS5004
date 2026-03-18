public abstract class PerformingArtist extends Artist {
  protected String[] movies;
  protected String[] series;
  protected String[] multimedia;

  public PerformingArtist(Name name, int age, String[] genres, String[] awards, String[] movies, String[] series, String[] multimedia) {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }
}