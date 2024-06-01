/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;

/**
 *
 * @author deniz
 */

/*
FriendsRequest sınıfı, bir arkadaşlık isteğini temsil eder.
 * 
 * Bu sınıf, arkadaşlık isteğini gönderen kullanıcıyı (sender) ve istek mesajını (requestMessage) içerir.
 * Arkadaşlık isteği gönderen kullanıcı ve mesaj, yapıcı metot aracılığıyla ayarlanır.
*/

public class FriendsRequest {
    private User sender;
    private String requestMessage;
    
    public FriendsRequest (User sender,String msg)
    {
        this.sender = sender;
        this.requestMessage = msg;
    }
    
    public User getRequestSender(){
        return sender;
    }
    
    public String getRequestMessage()
    {
        return requestMessage;
    }
    
    
    
}
