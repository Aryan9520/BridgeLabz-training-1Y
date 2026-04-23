import java.sql.*;

public class ProductInventoryTracker {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists product(pid int primary key, pname varchar(50), qty int)");

            st.executeUpdate("insert into product values(1,'Laptop',5)");
            st.executeUpdate("insert into product values(2,'Mouse',20)");
            st.executeUpdate("insert into product values(3,'Keyboard',8)");

            ResultSet rs = st.executeQuery("select * from product where qty < 10");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            st.executeUpdate("update product set qty = qty + 10 where pid = 1");

            st.executeUpdate("delete from product where pid = 3");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}