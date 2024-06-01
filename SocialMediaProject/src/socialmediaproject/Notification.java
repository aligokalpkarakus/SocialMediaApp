
package socialmediaproject;

/**
 *
 * @author deniz
 */

public class Notification {
    private User user; // Bu bildirim için ilgili kullanıcı
    private Group group; // Bu bildirimin ilişkili olduğu grup
    
    /**
     * Notification constructor.
     * Belirli bir kullanıcı ve grup için bildirim oluşturur ve bu bildirimi
     * gruptaki diğer kullanıcılara ekler.
     */
     
    public Notification(User user, Group group){
        this.user = user;
        this.group = group;
        
        // Gruptaki her bir üyeye bu bildirimi ekle
        for (int i = 0; i < group.getMembers().size(); i++) {
            if(!user.equals(group.getMembers().get(i))){
                group.getMembers().get(i).getNotificationList().add(this);

            }
        }
    }   
    
    /**
     * Bu bildirim için kullanıcıya gösterilecek metni oluşturur.
     */   
    public String getNotificationString(){
        String bildirim;
        bildirim = getUser().getKullaniciAdi() + " - " + getGroup().getGroupName() + " grubunda yeni bir gönderi yayinladi.";
        return bildirim;
    }
    
    public Notification getNotification(){
        return this;
    }

    
    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }
    
}
