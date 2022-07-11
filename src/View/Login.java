/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginController;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author JONATHAN
 */
public class Login {

    public static void main(String[] args) throws IOException {
        new Login();
    }

    public Login() throws IOException {
        LoginController controller = new LoginController();
        JFrame frame = new JFrame("Form Login");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);

        JLabel icon = new JLabel();
        BufferedImage foto = ImageIO.read(new File("C:\\Users\\JONATHAN\\Pictures\\Thumbumbsd.png"));
        Image fotoResize = foto.getScaledInstance(150, 170, Image.SCALE_DEFAULT);
        ImageIcon fotoFinal = new ImageIcon(fotoResize);
        icon.setIcon(fotoFinal);
        icon.setBounds(225, 5, 500, 60);

        //label email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 100, 90, 40);
        emailLabel.setFont(font1);

        JTextField email = new JTextField();
        email.setBounds(240, 105, 240, 30);
        email.setFont(font1);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(100, 180, 90, 40);
        passLabel.setFont(font1);

        //password
        JPasswordField pass = new JPasswordField();
        pass.setBounds(240, 185, 240, 30);
        pass.setFont(font1);

        JButton back = new JButton("Back");
        back.setFont(font1);
        back.setBounds(100, 330, 170, 40);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MainMenu();
            } 
        });
        JButton login = new JButton("Login");
        login.setFont(font1);
        login.setBounds(310, 330, 170, 40);
        
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kondisi=controller.login(email.getText(),pass.getText());
                JOptionPane.showMessageDialog(null, kondisi);
            }
            
        });

        frame.add(email);
        frame.add(emailLabel);
        frame.add(passLabel);
        frame.add(pass);
        frame.add(back);
        frame.add(login);
        frame.add(icon);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
