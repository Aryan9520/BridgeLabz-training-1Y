import java.sql.*;

public class CustomerContactDirectory {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists customers(id int primary key, name varchar(50), phone varchar(15))");

            st.executeUpdate("insert into customers values(1,'Aryan','9876543210')");
            st.executeUpdate("insert into customers values(2,'Rahul','9123456780')");
            st.executeUpdate("insert into customers values(3,'Riya','9988776655')");

            ResultSet rs = st.executeQuery("select * from customers where name like '%a%'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("update customers set phone='9999999999' where id=2");

            st.executeUpdate("delete from customers where id=3");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}