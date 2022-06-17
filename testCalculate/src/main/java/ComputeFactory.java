public class ComputeFactory {
    private static Sub sub = new Sub();
    private static Add add = new Add();

    public  static  Computable getCompute(String symbol) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       return  (Computable) Class.forName(symbol).newInstance();
    }
}
