import java.util.Scanner;
public class _0_ExceptionDemo {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            /* try-catch block */
//            System.out.print("Enter dividend: ");
//            int dividend = sc.nextInt();
//            System.out.print("Enter divisor: ");
//            int divisor = sc.nextInt();
//        try {
//            int result = dividend / divisor;
//            System.out.println("Result: " + result);
//        }
//            catch(ArithmeticException e){
//                System.out.print("Divisor can't be 0!");
//            }

        /* Nested try-catch block */
//        int arr[] = new int[5];
//        try{
//            arr[6] = 10/0;
//        }
//        catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
//        }

        // *****************************
//        int arr[] = new int[5];
//        try{
//            System.out.println("I'm first try block!");
//            try{
//                arr[6] = 10;
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//        catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
        // ***************************

        /* throw block */
//        int age = sc.nextInt();
//        if (age<18){
//            throw new RuntimeException("You are not eligible for vote.");
//        }
//        else{
//            System.out.println("You are eligible for vote.");
//        }

        /* throws block*/
        resultThrows(10,0);
    }

    public static void resultThrows(int dividend, int divisor) throws ArithmeticException{
        System.out.println("The result: "+(dividend/divisor));
    }
}
