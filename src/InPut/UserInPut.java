package InPut;

import java.util.Scanner;

public class UserInPut {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }
        System.out.println("Вы ввели не целоe число. Повторите ввод");
        scanner.next();
        return getInt();
    }

    public static int getInt(String message){
        System.out.println(message);
        return getInt();
    }

    public static double getDouble(){
        if(scanner.hasNextDouble()){
            return scanner.nextDouble();
        }
        System.out.println("Вы ввели не дробное число. Повторите ввод");
        scanner.next();
        return getDouble();
    }
}
