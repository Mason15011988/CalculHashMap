package Application;

import Exception.StopApplicationException;
import InPut.UserInPut;
import Operations.*;

public class Application {
    public static void start(){
        System.out.println("*** START ***");
        run();
        System.out.println("*** FINISH ***");
    }

    private static void run(){
        while (true){
            try {
                IOperation operation = getChooseOperation();
                int a = UserInPut.getInt("Введите a");
                int b = UserInPut.getInt("Введите b");
                int result = operation.calculation(a, b);
                System.out.println("==================");
                System.out.println(a + " " + operation.getSign() + " " + b + " = " + result);
                System.out.println("==================");
            }catch(StopApplicationException e){
                break;
            }
        }
    }
    private static IOperation getChooseOperation() throws StopApplicationException {
        showMenu();
        int numberOperation = UserInPut.getInt();
        switch (numberOperation){
            case 1:
                return new Addition();
            case 2:
                return new Subtraction();
            case 3:
                return new Multiplication();
            case 4:
                return new Division();
            case 0:
                throw new StopApplicationException();
            default:
                System.out.println("Нет такой операции");
                return getChooseOperation();
        }
    }

    private static void showMenu(){
        System.out.println("Выберите операцию");
        System.out.println("1 - сложение");
        System.out.println("2 - вычитание");
        System.out.println("3 - умножение");
        System.out.println("4 - деление");
        System.out.println("0 - выход");
    }


}
