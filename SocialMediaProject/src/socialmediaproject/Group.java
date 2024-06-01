package socialmediaproject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Group sınıfı, sosyal medya projesindeki grupları temsil eder.
 * 
 * Her bir grup, bir grup adı (groupName), bir sahip kullanıcı (owner), bir açıklama (Description), üyeler (members) ve gönderiler (posts) içerir.
 * 
 * Ayrıca, tüm grupları takip etmek için bir static ArrayList<Group> olan allGroups bulunur.
 * 
 * Grup sınıfı, grup oluşturma, üye ekleme ve grup içinde gönderi oluşturma gibi işlevleri içerir.
 * 
 */

public class Group {
    private String groupName;
    private User owner;
    private String Description;
    private static ArrayList<Group> allGroups = new ArrayList<Group>();
    
    //Bir nevi Observer
    private ArrayList<User> members;
    private ArrayList<Post> posts;

    public Group(String groupName,User owner,String Description) {
        this.Description = Description;
        this.owner = owner;
        this.groupName = groupName;
        this.members = new ArrayList<User>();
        this.posts = new ArrayList<Post>();
        allGroups.add(this);
    }
    
    public void addMember(User user) {
        if(!getMembers().contains(user))
        {
             members.add(user);
             JOptionPane.showMessageDialog(null, "Üye olundu","Bilgi", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(getMembers().contains(user))
            JOptionPane.showMessageDialog(null, "Zaten bu grubun üyesisin.","Bilgi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public void GroupPosta(Post post){
        getPosts().add(post);
        Notification not = new Notification(post.getAuthor(), this);
    }

    public String getGroupName() {
        return groupName;
    }

    public User getOwner() {
        return owner;
    }

    public String getDescription() {
        return Description;
    }

    public static ArrayList<Group> getAllGroups() {
        return allGroups;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public static void setAllGroups(ArrayList<Group> allGroups) {
        Group.allGroups = allGroups;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
    
    // Gruba üye ekleme
    
   // public notifyUsers()
}
