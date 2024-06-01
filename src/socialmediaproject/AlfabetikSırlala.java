/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author serda
 */
public class AlfabetikSırlala {
    
    
    public List<User> sirala(List<User> friends){
        
        Collections.sort(friends, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getKullaniciAdi().compareToIgnoreCase(u2.getKullaniciAdi());
            }
        });
        
        return friends;
    }
       
}

