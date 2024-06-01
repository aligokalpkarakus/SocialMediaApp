package socialmediaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author deniz
 */

/*
AlphabeticFriendsStrategy sınıfı, FriendsSearchStrategy arayüzünü implement ederek
arkadaşları alfabetik sıraya göre listelemek için kullanılan stratejiyi temsil eder.
*/
public class AlphabeticFriendsStrategy implements FriendsSearchStrategy {
    
    @Override
    public ArrayList<User> Listele(ArrayList<User> friends){
        Collections.sort(friends, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getKullaniciAdi().compareToIgnoreCase(u2.getKullaniciAdi());
            }
        });
        
        return friends;
       
    }
}
