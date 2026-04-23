import java.sql.*;

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cinema";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists movies(id int primary key, name varchar(50), seats int)");

            st.executeUpdate("insert into movies values(1,'Avengers',50)");
            st.executeUpdate("insert into movies values(2,'Jawan',0)");
            st.executeUpdate("insert into movies values(3,'Pathaan',30)");

            ResultSet rs = st.executeQuery("select * from movies where seats > 0");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            st.executeUpdate("update movies set seats = seats - 1 where id = 1");

            st.executeUpdate("delete from movies where id = 2");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}