package View;

import Controller.RegistrasiController;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Registrasi {

    public static void main(String[] args) {
        new Registrasi();
    }

    public Registrasi() {
        RegistrasiController controller = new RegistrasiController();
        JFrame frame = new JFrame("Form Registrasi");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);

        //label Judul
        JLabel judul = new JLabel("Register");
        judul.setBounds(225, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));

        //label email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 100, 90, 40);
        emailLabel.setFont(font1);

        JTextField email = new JTextField();
        email.setBounds(240, 105, 240, 30);
        email.setFont(font1);

        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setBounds(100, 140, 90, 40);
        namaLabel.setFont(font1);

        //textfield username
        JTextField nama = new JTextField();
        nama.setBounds(240, 145, 240, 30);
        nama.setFont(font1);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(100, 180, 90, 40);
        passLabel.setFont(font1);

        //password
        JPasswordField pass = new JPasswordField();
        pass.setBounds(240, 185, 240, 30);
        pass.setFont(font1);

        JLabel fotoLabel = new JLabel("Foto");
        fotoLabel.setBounds(100, 220, 90, 40);
        fotoLabel.setFont(font1);

        JButton foto = new JButton("open");
        foto.setBounds(240, 225, 80, 30);

        JLabel fotoPath = new JLabel("no file selected");
        fotoPath.setBounds(330, 225, 130, 30);
        fotoPath.setFont(font1);

        foto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = j.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File f = j.getSelectedFile();
                    BufferedImage bufferedImage = null;
                    fotoPath.setText(j.getSelectedFile().getAbsolutePath());
                }
            }

        });
        JLabel ketegoriLabel = new JLabel("Ketegori");
        ketegoriLabel.setBounds(100, 260, 90, 40);
        ketegoriLabel.setFont(font1);
        
        String[] kategoriUser = controller.comboBox();
        JComboBox cb=new JComboBox(kategoriUser);   
        cb.setBounds(240, 265, 240, 30);
        cb.setFont(font1);
        
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
        
        JButton regis = new JButton("Registrasi");
        regis.setFont(font1);
        regis.setBounds(310, 330, 170, 40);
        
        regis.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kondisi=controller.insertDatabase(email.getText(),nama.getText(),pass.getText(),fotoPath.getText(),cb.getSelectedIndex());
                JOptionPane.showMessageDialog(null, kondisi);
                if(kondisi.equals("Berhasil")){
                    frame.dispose();
                    try {
                        new Login();
                    } catch (IOException ex) {
                        Logger.getLogger(Registrasi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });

        frame.add(email);
        frame.add(judul);
        frame.add(emailLabel);
        frame.add(namaLabel);
        frame.add(nama);
        frame.add(passLabel);
        frame.add(pass);
        frame.add(fotoLabel);
        frame.add(foto);
        frame.add(fotoPath);
        frame.add(ketegoriLabel);
        frame.add(cb);
        frame.add(back);
        frame.add(regis);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
