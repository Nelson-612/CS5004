import java.util.ArrayList;
import java.util.List;

public class Catalog {
  private List<Item> items;

  public Catalog() {
    this.items = new ArrayList<>();
  }

  public Catalog(List<Item>items){
    this.items= items;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public List<Item> search (String keyword) {
    List<Item> result = new ArrayList<>();
    for (Item item : items) {
      if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  public List<Item> search (Author author) {
    List<Item> result = new ArrayList<>();
    for (Item item : items) {
      if (item.getCreator().equals(author)) {
        result.add(item);
      }
    }
    return result;
  }

  public List<Item> search (RecordingArtist artist) {
    List<Item> result = new ArrayList<>();
    for (Item item : items) {
      Creator creator = item.getCreator();

      if (creator instanceof  RecordingArtist) {
        if (creator.equals(artist)) {
          result.add(item);
        }
      }

      if (creator instanceof Band) {
        Band band = (Band) creator;
        for (RecordingArtist member: band.getMembers()) {
          if (member.equals(artist)) {
            result.add(item);
            break;
          }
        }
      }
    }
    return result;
  }
}
