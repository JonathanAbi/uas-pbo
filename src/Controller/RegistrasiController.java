package Controller;

import DatabaseHandler.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrasiController {

    DatabaseHandler conn = new DatabaseHandler();

    public String[] comboBox() {
        String[] cb = new String[3];
        int i = 0;

        try {
            conn.connect();
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from categoryuser");
            while (result.next()) {
                cb[i] = result.getString("nama");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cb;
    }
    
    public String insertDatabase(String email, String nama,String pass,String fotoPath,int kategori){
        pass=Hasher.password(pass);
        String query;
        try {
            conn.connect();
            PreparedStatement stmt;
            query = "INSERT INTO users(name,email,pass,idCategory,photo) VALUES(?,?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, pass);
            stmt.setInt(4, kategori);
            stmt.setString(5, fotoPath);
            stmt.executeUpdate();
            return "Berhasil";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Gagal";
        }
    }
}
