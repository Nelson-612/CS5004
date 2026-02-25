public class Musician extends Artist {

  private final String recordingCompany;
  private final String lastRecordAlbum;

  public Musician(Name name, int age,
      String[] genres, String[] awards,
      String recordingCompany,
      String lastRecordAlbum) {

    super(name, age, genres, awards);

    if (recordingCompany == null || lastRecordAlbum == null) {
      throw new IllegalArgumentException("Invalid musician info");
    }

    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}