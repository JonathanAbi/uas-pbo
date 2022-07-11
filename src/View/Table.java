package View;

import Controller.DataPenggunaController;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {

    public Table(int index) {
        DataPenggunaController controller = new DataPenggunaController();
        JFrame f;
        f = new JFrame();
        f.setLocationRelativeTo(null);
        String data[][] = controller.dataPengguna(index);
        String column[] = {"ID", "NAME", "EMAIL","PASSWORD","PHOTO"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
    }
}
