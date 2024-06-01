package socialmediaproject;
import java.util.ArrayList;
import java.util.List;


public class Group {
    private String groupName;
    private List<User> members;

    public Group(String groupName) {
        this.groupName = groupName;
        this.members = new ArrayList<>();
    }

    // Gruba üye ekleme
    public void addMember(User user) {
        members.add(user);
    }
}
