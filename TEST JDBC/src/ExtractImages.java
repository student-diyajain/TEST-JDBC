import java.sql.*;
import java.io.*;

public class ExtractImages {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/mydatabase";
    private static final String username ="root";
    private static final String password ="Diyajain@27";

    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String folder_path="C:\\Users\\Hp\\IdeaProjects\\TEST JDBC\\src\\";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("CLASSES LOADED SUCCESSFULY!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(url,username,password);

            /// DATABASE->JAVA->FOLDER(IMAGE)
            //retrieve the image
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT IMAGE_DATA FROM IMAGES WHERE IMAGE_ID=?;");
            preparedStatement.setInt(1,1);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){                //agr image aagyi
                byte[] imagedata= resultSet.getBytes("IMAGE_DATA");
                OutputStream outputStream=new FileOutputStream(folder_path+"EXTRACTEDIMAGE.jpg");     //jha image store krani hai
                outputStream.write(imagedata);
                System.out.println("IMAGE EXTRACTED SUCCESSFULLY!!");
            }else{
                System.out.println("image not found");
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
