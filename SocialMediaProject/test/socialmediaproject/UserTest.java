package socialmediaproject;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import socialmediaproject.User;
import socialmediaproject.UserFactory;

public class UserTest {
    
    @BeforeClass
    public static void setUp() {
        UserFactory.factory = new UserFactory();
    }
    
    @Test
    public void testCreateUser() {
        // Kullanıcı listesinin başlangıç boyutu
        int initialSize = User.getUserList().size();

        // Yeni kullanıcı oluşturulur
        UserFactory.factory.createUser("TestUser", socialmediaproject.Burclar.AKREP, "1234");

        // Kullanıcı listesinin sonraki boyutu
        int newSize = User.getUserList().size();

        // Yeni kullanıcının başarıyla eklenip eklenmediği kontrol edilir
        assertEquals(initialSize + 1, newSize);
        
    }

    
    @Test
    public void testAddFriend() {
        // Test senaryosu: İki kullanıcı oluşturulur.
        // İlk kullanıcı, ikinci kullanıcıyı arkadaş olarak ekler.
        // İlk kullanıcının arkadaş listesinde ikinci kullanıcının bulunup bulunmadığı kontrol edilir.
        // İkinci kullanıcının arkadaş listesinde ilk kullanıcının bulunup bulunmadığı kontrol edilir.
        
        // İki kullanıcı oluşturulur
        User user1 = new User("User1", socialmediaproject.Burclar.BASAK, "1234");
        User user2 = new User("User2", socialmediaproject.Burclar.YAY, "5678");
        
        // İlk kullanıcı, ikinci kullanıcıyı arkadaş olarak ekler
        user1.addFriend(user2);
        
        // İlk kullanıcının arkadaş listesinde ikinci kullanıcının bulunup bulunmadığı kontrol edilir
        assertTrue(user1.getFriends().contains(user2));
        
        // İkinci kullanıcının arkadaş listesinde ilk kullanıcının bulunup bulunmadığı kontrol edilir
        assertTrue(user2.getFriends().contains(user1));
        

    }
    
    @Test
    public void testSendFriendRequest() {
        // Test senaryosu: İki kullanıcı oluşturulur.
        // İlk kullanıcı, ikinci kullanıcıya arkadaşlık isteği gönderir.
        // İkinci kullanıcının arkadaşlık istekleri listesinde ilk kullanıcının bulunup bulunmadığı kontrol edilir.
        
        // İki kullanıcı oluşturulur
        User user3 = new User("User3", socialmediaproject.Burclar.OGLAK, "1234");
        User user4 = new User("User4", socialmediaproject.Burclar.YENGEC, "5678");
        
        // İlk kullanıcı, ikinci kullanıcıya arkadaşlık isteği gönderir
        user3.sendFriendRequest(user4, "Merhaba, arkadaş olalım mı?");
        
        // İkinci kullanıcının arkadaşlık istekleri listesinde ilk kullanıcının bulunup bulunmadığı kontrol edilir
        assertTrue(user4.getFriendRequests().stream().anyMatch(req -> req.getRequestSender().equals(user3)));
    }
}