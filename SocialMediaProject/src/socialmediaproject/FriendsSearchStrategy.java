
package socialmediaproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deniz
 */

/*
FriendsSearchStrategy arayüzü, arkadaşları listeleme stratejilerini belirlemek için kullanılır.
Bu arayüz, Listele adında bir metot içerir. Bu metot, bir ArrayList<User> alır ve arkadaşları listeleme stratejisine göre sıralanmış bir ArrayList<User> döndürür.

*/

//Friend listeleme
public interface FriendsSearchStrategy {
    public ArrayList<User> Listele(ArrayList<User> friends);
}


