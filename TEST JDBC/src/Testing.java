import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testing {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Diyajain@27";

        try {
            // Load MySQL driver (not mandatory for JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println(con);

            // Create statement
            Statement stmt = con.createStatement();
            System.out.println("Connected successfully!");

            // Close connection
            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
