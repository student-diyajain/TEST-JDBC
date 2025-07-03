import java.sql.*;   //import jdbc packages
import java.util.Scanner;


public class BatchProcessing {
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


        try {
            //connect
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            //use statement-
            Statement stmt=con.createStatement();
            stmt.addBatch("INSERT INTO EMPLOYEES (ID,NAME,JOB_TITLE,SALARY) VALUES (13,'SHIVAM','JAVA DEVELOPER',95000.0);");
            stmt.addBatch("INSERT INTO EMPLOYEES (ID,NAME,JOB_TITLE,SALARY) VALUES (14,'RAHUL','PYTHON DEVELOPER',65000.0);");
            stmt.addBatch("INSERT INTO EMPLOYEES (ID,NAME,JOB_TITLE,SALARY) VALUES (15,'AJAY','APP DEVELOPER',150000.0);");
            int [] BatchResult=stmt.executeBatch();
              con.commit();
            System.out.println("BATCH EXECUTED SUCCESSFULLY!");



            //create PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(query1);

             while(true) {
                 //fill placeholder
                 System.out.println("enter id:");
                 pstmt.setInt(1, s.nextInt());
                 System.out.println("enter name:");
                 pstmt.setString(2, s.next());
                 System.out.println("enter jobtitle:");
                 pstmt.setString(3, s.next());
                 System.out.println("enter salary:");
                 pstmt.setDouble(4, s.nextDouble());
                      pstmt.addBatch();
                 System.out.println();
                 System.out.println("WANT TO ADD MORE?Y:N");

                      String decision=s.next();
                      if(decision.toUpperCase().equals("N")){
                          break;
                      }
             }
            //execute query
            int[] rowsaffected = pstmt.executeBatch();
             con.commit();
            System.out.println("BATCH EXECUTED SUCCESSFULLY!");


            System.out.println("===========================================================================");

            //closing
            pstmt.close();
            con.close();
            System.out.println();
            System.out.println("connection successfully close!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}


