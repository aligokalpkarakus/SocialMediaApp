package socialmediaproject;
import java.util.Comparator;
/**
 *
 * @author deniz
 */

/**
 * HoroscopeComparator sınıfı, burçlara göre kullanıcıları karşılaştırmak için bir Comparator sağlar.
 * 
 * Bu sınıf, Comparator arayüzünü uygular ve compare metodu ile iki kullanıcıyı burçlarına göre karşılaştırır.
 * 
 * Karşılaştırma sonucu, kullanıcıların burçlarının sıralama önceliğine göre belirlenir.
 * 
 */

public class HoroscopeComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getHoroscope().compareTo(u2.getHoroscope());
    }
}
