import java.sql.*;   //import jdbc packages
public class RetrieveData {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username="root";
        String password="Diyajain@27";
        String query="select * from employees;";
        //load drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers load successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
           //connect
           Connection con=DriverManager.getConnection(url,username,password);
           //create statement
            Statement stmt=con.createStatement();
            //execute query
            ResultSet rs=stmt.executeQuery(query);
            //retrieve the data
            while(rs.next()){
                    int empId=rs.getInt("ID");
                        String empName=rs.getString("NAME");
                        String empJobTitle=rs.getString("JOB_TITLE");
                    double empSalary=rs.getDouble("SALARY");
                System.out.println("==================================================================");
                System.out.println("id:"+empId+"\n"+"name:"+empName+"\n"+"jobtitle:"+empJobTitle+"\n"+"salary:"+empSalary);
            }
            //closing
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("connection successfully close!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
