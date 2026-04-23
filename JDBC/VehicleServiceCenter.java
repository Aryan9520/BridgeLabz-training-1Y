import java.sql.*;

public class VehicleServiceCenter {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/servicecenter";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists vehicles(regNo varchar(20) primary key, owner varchar(50), status varchar(20))");

            st.executeUpdate("insert into vehicles values('UP15AB1234','Aryan','Pending')");
            st.executeUpdate("insert into vehicles values('UP16CD5678','Rahul','Completed')");
            st.executeUpdate("insert into vehicles values('UP14EF9012','Riya','Pending')");

            ResultSet rs = st.executeQuery("select * from vehicles where status='Pending'");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("update vehicles set status='Completed' where regNo='UP15AB1234'");

            st.executeUpdate("delete from vehicles where regNo='UP16CD5678'");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}