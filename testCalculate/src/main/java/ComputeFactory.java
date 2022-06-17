public class ComputeFactory {
    private static Sub sub = new Sub();
    private static Add add = new Add();

    public  static  Computable getCompute(char symbol)  {
        switch (symbol){
            case '+':
                return add;
            case '-':
                return sub;
                default:
                    throw new IllegalArgumentException();
        }
    }
}
