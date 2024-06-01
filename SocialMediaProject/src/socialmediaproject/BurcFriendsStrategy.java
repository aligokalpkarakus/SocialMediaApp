/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author deniz
 */

/*
BurcFriendsStrategy sınıfı, FriendsSearchStrategy arayüzünü implement ederek
 * kullanıcıların arkadaşlarını burçlarına göre sıralamak için kullanılan bir sıralama stratejisini temsil eder.
 * 
 * Bu sınıf, arkadaş listesini kullanıcıların burçlarına göre sıralamak için Collections.sort() metodunu kullanır.
 * Sıralama işlemi için HoroscopeComparator sınıfını kullanır.
*/

//
public class BurcFriendsStrategy implements FriendsSearchStrategy {
    @Override
    public ArrayList<User> Listele(ArrayList<User> friends){
        
        Collections.sort(friends, new HoroscopeComparator());

        return friends;
    }
}
