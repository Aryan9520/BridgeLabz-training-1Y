import java.sql.*;

public class BookstoreSalesTracking {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists sales(id int primary key, bookName varchar(100), quantity int, price double)");

            st.executeUpdate("insert into sales values(1,'Java Basics',2,450)");
            st.executeUpdate("insert into sales values(2,'Python Guide',1,500)");
            st.executeUpdate("insert into sales values(3,'SQL Master',3,350)");

            ResultSet rs = st.executeQuery("select * from sales where quantity > 1");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(4));
            }

            st.executeUpdate("update sales set quantity = 4 where id = 1");

            st.executeUpdate("delete from sales where id = 2");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}