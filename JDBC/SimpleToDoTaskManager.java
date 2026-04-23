import java.sql.*;

public class SimpleToDoTaskManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/todo";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists tasks(id int primary key, title varchar(100), status varchar(20))");

            st.executeUpdate("insert into tasks values(1,'Complete Assignment','Pending')");
            st.executeUpdate("insert into tasks values(2,'Buy Groceries','Completed')");
            st.executeUpdate("insert into tasks values(3,'Study Java','Pending')");

            ResultSet rs = st.executeQuery("select * from tasks where status='Pending'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("update tasks set status='Completed' where id=1");

            st.executeUpdate("delete from tasks where status='Completed'");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}