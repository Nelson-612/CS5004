public class Poet extends Artist {

  private final String publishingCompany;
  private final String lastPublishedCollection;

  public Poet(Name name, int age,
      String[] genres, String[] awards,
      String publishingCompany,
      String lastPublishedCollection) {

    super(name, age, genres, awards);

    if (publishingCompany == null || lastPublishedCollection == null) {
      throw new IllegalArgumentException("Invalid poet info");
    }

    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }
}