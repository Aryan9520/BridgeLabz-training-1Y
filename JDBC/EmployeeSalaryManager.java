import java.sql.*;

public class EmployeeSalaryManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists employee(id int primary key, name varchar(50), salary double)");

            st.executeUpdate("insert into employee values(1,'Aryan',25000)");
            st.executeUpdate("insert into employee values(2,'Rahul',40000)");
            st.executeUpdate("insert into employee values(3,'Riya',12000)");

            ResultSet rs = st.executeQuery("select * from employee where salary > 30000");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
            }

            st.executeUpdate("update employee set salary = salary + (salary * 0.10) where id = 1");

            st.executeUpdate("delete from employee where salary < 15000");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}