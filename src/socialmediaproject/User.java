package socialmediaproject;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class User {
    private String kullaniciAdi;
    private String parola;
    private static ArrayList<User> userList = new ArrayList<User>(); //user listemize her yerden ulaşabilmek için statik yaptık. 
    
    private List<User> friends;
    private List<Post> posts;
    
    DuvarYazisi duvarYazisi; 

                      
    public User(String kullaniciAdi, String parola) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.duvarYazisi = new DuvarYazisi("İlk duvar yazınızı girin!", Color.BLACK);
    }
    
    static {
        
        //User factory aracılığıyla başlangıçta userlar eklenir.
        UserFactory.factory.createUser("user1", "1234");
        UserFactory.factory.createUser("user2", "1234");
        UserFactory.factory.createUser("user3", "1234");
        
        //test amaçlı arkadaş ekleme işlemleri.
        User user1 = getUserByName("user1");
        User user2 = getUserByName("user2");
        User user3 = getUserByName("user3");
        
        
        user1.addFriend(user2);
        user1.addFriend(user3);
        
    }
    
    
    
    // Statik loggedInUser alanı
    private static User loggedInUser;

    // loggedInUser'ı ayarlamak için bir metod
    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    // loggedInUser'ı almak için bir metod
    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public List<User> getFriends() {
        return friends;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void addUserList(User user) {
        if(!userList.contains(user))
            userList.add(user);
    }
    
    public void addFriend(User friend){
        if (friends.contains(friend)) {
            JOptionPane.showMessageDialog(null, "Bu kişi zaten arkadaşınız.");
        } else {
            JOptionPane.showMessageDialog(null, "Arkadaş eklendi: " + friend.getKullaniciAdi());
            friends.add(friend);
            friend.friends.add(this);
        }
    }
    
    public void sharePost(Post post){
        posts.add(post);
    }
    
    @Override
    public String toString() {
        return kullaniciAdi; // Kullanıcı adını döndürmek için
    }
    
    //nickname'e göre userlistte arama yapar nickname'i eşleşen kullanıcıyı döndürür.
    private static User getUserByName(String nickname)
    { 
        return userList.stream().filter(user -> nickname.equals(user.getKullaniciAdi())).findFirst().orElse(null);      
    }
    
    
   

}
