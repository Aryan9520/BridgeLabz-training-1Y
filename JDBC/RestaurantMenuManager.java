import java.sql.*;

public class RestaurantMenuManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/restaurant";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists menu(id int primary key, itemName varchar(50), price double)");

            st.executeUpdate("insert into menu values(1,'Burger',150)");
            st.executeUpdate("insert into menu values(2,'Pizza',250)");
            st.executeUpdate("insert into menu values(3,'Pasta',180)");

            ResultSet rs = st.executeQuery("select * from menu where price < 200");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
            }

            st.executeUpdate("update menu set price = 220 where id = 3");

            st.executeUpdate("delete from menu where id = 2");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}