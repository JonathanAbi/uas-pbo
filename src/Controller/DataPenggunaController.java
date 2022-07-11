
package Controller;

import DatabaseHandler.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataPenggunaController {
    public String[][] dataPengguna(int index){
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String pengguna[][]=new String[2][5];
        int x=0;
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from users where idCategory='"+index+"'");
            while(result.next()){
                    pengguna[x][0]=result.getString("id");
                    pengguna[x][1]=result.getString("name");
                    pengguna[x][2]=result.getString("email");
                    pengguna[x][3]=result.getString("pass");
                    pengguna[x][4]=result.getString("photo");;
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pengguna;
    }
}
