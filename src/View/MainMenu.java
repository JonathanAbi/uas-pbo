package View;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu {

    public static void main(String[] args) {
        new MainMenu();
    }

    public MainMenu() {
        JFrame frame = new JFrame("Menu");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.BOLD, 20);

        JButton login = new JButton("Login");
        login.setBounds(110, 60, 150, 50);
        login.setFont(font1);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                try {
                    new Login();
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        JButton regis = new JButton("Registrasi");
        regis.setBounds(110, 130, 150, 50);
        regis.setFont(font1);
        regis.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Registrasi();
            }

        });

        JButton lihatData = new JButton("Lihat Data");
        lihatData.setBounds(110, 200, 150, 50);
        lihatData.setFont(font1);
        lihatData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lihatData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new DataPengguna();
            }

        });

        frame.add(login);
        frame.add(regis);
        frame.add(lihatData);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
