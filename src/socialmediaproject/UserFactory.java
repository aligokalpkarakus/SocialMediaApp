/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;

/**
 *
 * @author deniz
 */
public class UserFactory {
    
    //Singleton bir factory class'ı
    static UserFactory factory;
    
    public UserFactory()
    {
        if(this.factory == null)
            factory = this;
    }
    
    void createUser(String nickname,String password)
    {
        User user = new User(nickname,password);
        User.addUserList(user);
    }
    
}
