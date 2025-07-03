import java.sql.*;   //import jdbc packages
public class DeleteData {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username="root";
        String password="Diyajain@27";
        String query="DELETE FROM EMPLOYEES WHERE ID=5;";
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
            int rowsaffected=stmt.executeUpdate(query);
            //check operation
            if(rowsaffected>0){
                System.out.println(rowsaffected +"row(s) affected");
            }else{
                System.out.println(rowsaffected +"row(s) affected");
            }
            //closing
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("connection successfully close!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
