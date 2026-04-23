import java.sql.*;

public class OnlineCourseEnrollmentSystem {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/institute";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists enrollments(id int primary key, student varchar(50), course varchar(50))");

            st.executeUpdate("insert into enrollments values(1,'Aryan','Java')");
            st.executeUpdate("insert into enrollments values(2,'Rahul','Python')");
            st.executeUpdate("insert into enrollments values(3,'Riya','Java')");

            ResultSet rs = st.executeQuery("select * from enrollments where course='Java'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("update enrollments set course='C++' where id=2");

            st.executeUpdate("delete from enrollments where id=3");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}