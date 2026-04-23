import java.sql.*;

public class LibraryBookManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists books(id int primary key, title varchar(100), author varchar(50), status varchar(10))");

            st.executeUpdate("insert into books values(1,'Java Basics','James','Available')");
            st.executeUpdate("insert into books values(2,'SQL Guide','John','Available')");
            st.executeUpdate("insert into books values(3,'Python Book','Mark','Issued')");

            ResultSet rs = st.executeQuery("select * from books where status='Available'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

            st.executeUpdate("update books set status='Issued' where id=1");

            st.executeUpdate("delete from books where id=3");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}