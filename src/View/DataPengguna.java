
package View;

import Controller.RegistrasiController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DataPengguna {
    public static void main(String[] args) {
        new DataPengguna();
    }
    public DataPengguna(){
        RegistrasiController controller = new RegistrasiController();
        JFrame frame = new JFrame("Data Pengguna");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);
        
        JLabel judul = new JLabel("Data Pengguna");
        judul.setBounds(80, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));
        
        String[] kategoriUser = controller.comboBox();
        JComboBox cb=new JComboBox(kategoriUser);   
        cb.setBounds(70, 100, 240, 30);
        cb.setFont(font1);
        
        JButton search = new JButton("Search");
        search.setFont(font1);
        search.setBounds(70, 150, 240, 50);
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Table(cb.getSelectedIndex());
            }
            
        });
        
        frame.add(judul);
        frame.add(cb);
        frame.add(search);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
