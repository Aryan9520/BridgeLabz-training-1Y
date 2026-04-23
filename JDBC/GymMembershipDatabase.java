import java.sql.*;

public class GymMembershipDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists members(id int primary key, name varchar(50), type varchar(20), months int)");

            st.executeUpdate("insert into members values(1,'Aryan','Premium',12)");
            st.executeUpdate("insert into members values(2,'Rahul','Basic',6)");
            st.executeUpdate("insert into members values(3,'Riya','Premium',8)");

            ResultSet rs = st.executeQuery("select * from members where type='Premium'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
            }

            st.executeUpdate("update members set months = months + 3 where id = 2");

            st.executeUpdate("delete from members where months <= 0");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}