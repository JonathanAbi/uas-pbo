package Controller;

import DatabaseHandler.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public String login(String email, String pass) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        pass = Hasher.password(pass);
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from users where email='" + email + "'");

            if (result.next()) {
                if (pass.equals(result.getString("pass"))) {
                    return "Login Berhasil!";
                } else {
                    return "Password Salah!";
                }
            } else {
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
