import java.util.Scanner;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        //first case
//        try{
//            System.out.println("enter values:");
//        int a=s.nextInt();
//        int b=s.nextInt();
//        System.out.println(a/b);
//        }
//        catch(ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
//         catch(Exception e){           //parent class should be write after child class
//            System.out.println(e.getMessage());
//         }

        System.out.println("--------------------------------------------------------");

        //second case
//        int a[]=new int[5];
//        try {
////            a[6] = 10;        ArrayIndexOutOfBoundsException
////            a[5] = 10 / 0;    ArithmeticException
//            a[7]=10/0;
//
//        }catch (ArithmeticException|ArrayIndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
//        }

        System.out.println("--------------------------------------------------------");

        //third case
        System.out.println("enter age:");
        int age=s.nextInt();
        if(age<18){
        //System.out.println("less than 18");
        //to make this statement exception
        throw new RuntimeException("sorry! you are not eligible.");
        }
        else {
            //System.out.println("grater or equal than 18");
            //to make this statement exception
            throw new ArithmeticException("you are eligible.");
        }



    }
}
