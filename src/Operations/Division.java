package Operations;

public class Division implements IOperation {
    @Override
    public int calculation(int a, int b) {
        try{
            return a / b;
        }catch (ArithmeticException e){
            System.out.println("Ошибка. Попытка деления на 0");
            return 0;
        }
    }

    @Override
    public char getSign() {
        return '/';
    }
}
