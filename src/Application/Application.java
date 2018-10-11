package Application;

import Exception.StopApplicationException;
import InPut.UserInPut;
import Operations.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static Map<Integer,IOperation> map;



    public static void start(){
        System.out.println("*** START ***");
        zap();
        run();
        System.out.println("*** FINISH ***");
    }

    private static void zap() {
        map = new HashMap<>();
        map.put(1,new Addition());
        map.put(2,new Subtraction());
        map.put(3,new Multiplication());
        map.put(4,new Division());
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
        if (numberOperation==0){
            throw new StopApplicationException();
        }else{
            if (map.get(numberOperation)!=null){
                return map.get(numberOperation);
            }
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
