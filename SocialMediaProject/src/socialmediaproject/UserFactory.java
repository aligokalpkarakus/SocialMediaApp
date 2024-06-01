
package socialmediaproject;

/**
 *
 * @author deniz
 */


public class UserFactory {
    
    //Singleton bir factory class'ı
    public static UserFactory factory;
    
    public UserFactory()
    {
        if(this.factory == null)
            factory = this;
    }
    
    public void createUser(String nickname,Burclar burc,String password)
    {
        User user = new User(nickname,burc,password);
        User.addUserList(user);
    }
    
}
