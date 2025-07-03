import java.sql.*;
import java.io.*;

public class InsertImages {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/mydatabase";
    private static final String username ="root";
    private static final String password ="Diyajain@27";

    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String image_path1="C:\\Users\\Hp\\IdeaProjects\\TEST JDBC\\src\\IMAGE1.png";
        String image_path2="C:\\Users\\Hp\\IdeaProjects\\TEST JDBC\\src\\IMAGE2.avif";

        try{
           Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("CLASSES LOADED SUCCESSFULY!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(url,username,password);
           /// FOLDER(IMAGE)->JAVA->DATABASE
           //convert image into byte format-
            FileInputStream fileInputStream=new FileInputStream(image_path2);
            //store this image into array-
            byte[] imagedata=new byte[fileInputStream.available()];  //creates empty array of image size
            fileInputStream.read(imagedata);

            //insert into database-
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO IMAGES(IMAGE_DATA) VALUES(?)");
            preparedStatement.setBytes(1,imagedata);
            int rowsAffected= preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("IMAGE INSERTED SUCCESSFULY!!");
            }
            else{
                System.out.println("IMAGE NOT INSERTED!!");
            }
        } catch (SQLException  e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
