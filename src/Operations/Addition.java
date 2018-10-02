package Operations;

public class Addition implements IOperation {
    @Override
    public int calculation(int a, int b) {
        return a + b ;
    }

    @Override
    public char getSign() {
        return '+';
    }
}
