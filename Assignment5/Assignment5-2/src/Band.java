import java.util.List;
import java.util.ArrayList;

public class Band implements Creator{
 private String name;
 private List<RecordingArtist> members;

 public Band(String name) {
   this.name = name;
   this.members = new ArrayList<>();
 }

 public void addMember(RecordingArtist member) {
   members.add(member);
 }

 public String getName() {
   return name;
 }

 public List<RecordingArtist> getMembers() {
   return members;
 }
}
