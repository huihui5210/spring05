public class Calculator {
    public int compute(int num1, int num2, char c)  {
        Computable comute = ComputeFactory.getCompute(c);
        return comute.compute(num1,num2);
    }
}
