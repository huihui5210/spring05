public class Calculator {
    public int compute(int num1, int num2, String c) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Computable comute = ComputeFactory.getCompute(c);
        return comute.compute(num1,num2);
    }
}
