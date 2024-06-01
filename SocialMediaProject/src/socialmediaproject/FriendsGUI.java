/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
FriendsGUI sınıfı, arkadaş ekleme işlemlerini gerçekleştirmek için bir Swing penceresi oluşturur.
 * 
 * Bu sınıf, bir kullanıcı arayüzü (GUI) sağlar ve kullanıcıya arkadaş eklemek için bir JComboBox ve bir JButton sunar.
 * Kullanıcı, JComboBox'ten arkadaş eklemek istediği kullanıcıyı seçer ve "Arkadaş Ekle" düğmesine tıklar.
*/

public class FriendsGUI extends JFrame {
    private JComboBox<User> userComboBox;
    private JButton addButton;

    public FriendsGUI() {
        setTitle("Arkadaş Ekle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Arkadaş Eklemek İstediğiniz Kullanıcı:");
        userComboBox = new JComboBox<>(User.getUserList().toArray(new User[0]));

        addButton = new JButton("Arkadaş Ekle");

        panel.add(label);
        panel.add(userComboBox);
        panel.add(addButton);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = (User) userComboBox.getSelectedItem();
                // Seçilen kullanıcıyı arkadaş olarak ekleme işlemi
                // Örneğin: loggedInUser.addFriend(selectedUser);

                JOptionPane.showMessageDialog(FriendsGUI.this, "Arkadaş eklendi: " + selectedUser.getKullaniciAdi());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FriendsGUI().setVisible(true);
            }
        });
    }
}
