package JV2_Session6;

//Buoc 1: import package
import java.sql.*;

public class Main {
    public static void main(String[] args){
        try {
            // buoc 2: dang ki driver
            Class.forName("com.mysql.jdbc.Driver");

            // buoc 3: tao ket noi Db
            String URL = "jdbc:mysql://localhost:3306/t1807m";
            Connection conn = DriverManager.getConnection(URL,"t1807m","t1807m123");

            //buoc 4: truy van du lieu
            String insert_sql = "INSERT INTO student (id,name,age,mark) VALUES(1,'le van minh',23,9) ";
            String sql = "SELECT * FROM student ";
            String edit_sql = "UPDATE student " + "SET name = 'Ta Minh Chien', age = 21 ,mark =10 " + "WHERE id = 2";
            Statement statement = conn.createStatement();

           /* statement.executeUpdate(insert_sql);*/
            statement.executeUpdate(edit_sql);


            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("name: "+rs.getString("name"));
                System.out.println("age: "+rs.getInt("age"));
                System.out.println("mark: "+rs.getInt("mark"));
                System.out.println("-------------------------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
