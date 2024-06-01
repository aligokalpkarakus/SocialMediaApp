package socialmediaproject;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

enum Burclar{
    KOC,
    BOGA,
    IKIZLER,
    YENGEC,
    ASLAN,
    BASAK,
    TERAZI,
    AKREP,
    YAY,
    OGLAK,
    KOVA,
    BALIK 
    }

public class User {
    
    
    
    //kullanıcıya ait değişkenler
    private String kullaniciAdi;
    private String parola;
    
    private Burclar burc;
    
    private static ArrayList<User> userList = new ArrayList<User>(); //user listemize her yerden ulaşabilmek için statik yaptık. 
    private boolean isAccountPrivate = false; //private mode
    
    private ArrayList<User> friends;
    private ArrayList<FriendsRequest> friendRequests;
    private ArrayList<Notification> notifications;
    
    private ArrayList<Post> posts;
    
    DuvarYazisi duvarYazisi; 

    //constructor                  
    public User(String kullaniciAdi,Burclar burc, String parola) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.burc = burc;
        this.friends = new ArrayList<User>();
        this.posts = new ArrayList<Post>();
        this.friendRequests = new ArrayList<FriendsRequest>();
        this.notifications = new ArrayList<Notification>();
        this.duvarYazisi = new DuvarYazisi("Ilk duvar yazınızı girin!", Color.BLACK);
    }
    
    //hazır hesaplar
    static {
        
        //User factory aracılığıyla başlangıçta userlar eklenir.
        UserFactory.factory.createUser("Serdar",Burclar.AKREP, "1234");
        UserFactory.factory.createUser("Gökalp",Burclar.ASLAN, "1234");
        UserFactory.factory.createUser("Deniz",Burclar.IKIZLER ,"1234");
        UserFactory.factory.createUser("Messi",Burclar.BALIK ,"1234");
        //test amaçlı arkadaş ekleme işlemleri.
        User user1 = getUserByName("Serdar");
        User user2 = getUserByName("Gökalp");
        User user3 = getUserByName("Deniz");
        User user4 = getUserByName("Messi");
        
        Group group1 = new Group("Ege Üni",user1, "Bu bir açıklama mesajıdır");
        
        
        //user1.addFriend(user2);
        //user1.addFriend(user3);
        //user1.addFriend(user4);
        
    }
    
    
    //getter, setter ve gerekli metodlar.
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

    public ArrayList<User> getFriends() {
        return friends;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }
    
    //kullanıcı listesine eklenme
    public static void addUserList(User user) {
        if(!userList.contains(user))
            userList.add(user);
    }
    
    //arkadaş ekleme
    public void addFriend(User friend){
        if (friends.contains(friend)) {
            JOptionPane.showMessageDialog(null, "Bu kişi zaten arkadaşınız.");
        } else {
            JOptionPane.showMessageDialog(null, "Arkadaş eklendi: " + friend.getKullaniciAdi());
            friends.add(friend);
            friend.friends.add(this);
        }
    }
    
    //post paylaşımı
    public void sharePost(Post post){
        posts.add(post);
    }
    
    //arkadaş kabul etme sistemi
    public void AcceptFriendRequest(FriendsRequest req)
    {
        int dialogResult = JOptionPane.showConfirmDialog (null, req.getRequestSender().getKullaniciAdi()+" adlı kullanıcıyı arkadaş olarak eklemek istediğinize emin misiniz?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
        addFriend(req.getRequestSender());   
        friendRequests.remove(req);
        }
        else if(dialogResult == JOptionPane.NO_OPTION)
        {
         friendRequests.remove(req);
        }
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
    
    public Burclar getHoroscope(){
        return burc;
    }
    
    public ArrayList<FriendsRequest> getFriendRequests(){
        return friendRequests;
    }
    
    public void sendFriendRequest(User user,String str)
    {
        FriendsRequest req = new FriendsRequest(this,str);
        user.getFriendRequests().add(req);
    }
    
    public void sendNotifications(User user, Notification not){
        user.getNotificationList().add(not);
    }
    public ArrayList<Notification> getNotificationList(){
        return notifications;
    }
    
    public void PostText(String text)
    {
        Post post = new Post(text, this);
        posts.add(post);
        
    }
    
    public ArrayList<Post> getPosts()
    {
        return posts;
    }
   
    
    public void setPrivateMode(boolean mode){
        isAccountPrivate = mode;
    }
    
    public boolean isPrivateMode(){
        return isAccountPrivate;
    }
}
