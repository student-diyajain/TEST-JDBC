import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/mydatabase";
    private static final String username ="root";
    private static final String password ="Diyajain@27";

    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
        String withdrawQuery="update accounts set balance=balance-? where account_number=?";
        String depositQuery="update accounts set balance=balance+? where account_number=?";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("CLASSES LOADED SUCCESSFULY!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("CONNECTION ESTABLISHED SUCCESSFUL!!!");
            con.setAutoCommit(false);

                PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                withdrawStatement.setDouble(1, 1000);
                withdrawStatement.setString(2, "account456");
                int withdrawsAffected=withdrawStatement.executeUpdate();
                PreparedStatement depositStatement = con.prepareStatement(depositQuery);
                depositStatement.setDouble(1, 1000);
                depositStatement.setString(2, "account789");
                int depositAffected=depositStatement.executeUpdate();
                if(withdrawsAffected>0 && depositAffected>0){
                    con.commit();
                    System.out.println("Transaction Successful!");}
                else{
                    con.rollback();
                    System.out.println("Transaction failed!");
                }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
