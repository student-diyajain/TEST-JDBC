import java.sql.*;   //import jdbc packages
import java.util.Scanner;


public class PreparedStatements {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Diyajain@27";

        //load drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers load successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
          Scanner s=new Scanner(System.in);
          String query1 ="INSERT INTO EMPLOYEES(ID,NAME,JOB_TITLE,SALARY) VALUES (?,?,?,?)";
          String query2 ="SELECT * FROM EMPLOYEES WHERE NAME=?;";

        try {
            //connect
            Connection con = DriverManager.getConnection(url, username, password);
            //create PreparedStatement
            PreparedStatement pstmt1 = con.prepareStatement(query1);
            PreparedStatement pstmt2 = con.prepareStatement(query2);

            //fill placeholder
            System.out.println("enter id:");
            pstmt1.setInt(1,s.nextInt());
            System.out.println("enter name:");
            pstmt1.setString(2,s.next());
            System.out.println("enter jobtitle:");
            pstmt1.setString(3,s.next());
            System.out.println("enter salary:");
            pstmt1.setDouble(4,s.nextDouble());
            System.out.println();
            //execute query
            int rowsaffected = pstmt1.executeUpdate();
            //check operation
            if (rowsaffected > 0) {
                System.out.println(rowsaffected + "row(s) affected");
            } else {
                System.out.println(rowsaffected + "row(s) affected");
            }

            System.out.println("===========================================================================");
            System.out.println("enter name you want to find:");
            pstmt2.setString(1,s.next());



            //data retrieval
            ResultSet rs= pstmt2.executeQuery();
            while(rs.next()){

                int empId=rs.getInt("ID");
                String empName=rs.getString("NAME");
                String empJobTitle=rs.getString("JOB_TITLE");
                double empSalary=rs.getDouble("SALARY");
                System.out.println("===========================================================================");
                System.out.println("id:"+empId+"\n"+"name:"+empName+"\n"+"jobtitle:"+empJobTitle+"\n"+"salary:"+empSalary);
            }

            //closing
                 rs.close();
                 pstmt1.close();
                 pstmt2.close();
                 con.close();
            System.out.println();
            System.out.println("connection successfully close!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
