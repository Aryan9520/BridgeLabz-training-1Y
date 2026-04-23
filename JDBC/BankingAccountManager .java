import java.sql.*;

public class BankingAccountManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("create table if not exists accounts(accNo int primary key, name varchar(50), balance double)");

            st.executeUpdate("insert into accounts values(101,'Aryan',15000)");
            st.executeUpdate("insert into accounts values(102,'Rahul',8000)");
            st.executeUpdate("insert into accounts values(103,'Riya',25000)");

            ResultSet rs = st.executeQuery("select * from accounts where balance > 10000");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
            }

            st.executeUpdate("update accounts set balance = balance + 5000 where accNo = 102");

            st.executeUpdate("update accounts set balance = balance - 2000 where accNo = 101");

            st.executeUpdate("delete from accounts where accNo = 103");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}