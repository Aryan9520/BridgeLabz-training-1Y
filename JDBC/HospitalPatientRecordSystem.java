import java.sql.*;

public class HospitalPatientRecordSystem {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists patients(id int primary key, name varchar(50), disease varchar(50))");

            st.executeUpdate("insert into patients values(1,'Aryan','Fever')");
            st.executeUpdate("insert into patients values(2,'Rahul','Diabetes')");
            st.executeUpdate("insert into patients values(3,'Riya','Fever')");

            ResultSet rs = st.executeQuery("select * from patients where disease='Fever'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("update patients set disease='Cold' where id=1");

            st.executeUpdate("delete from patients where id=3");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}