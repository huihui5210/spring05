import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void shouldReturn2When1Plus1() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Calculator calculator = new Calculator();
        int ans = calculator.compute(1, 2, "Add");
        int expectAnswer = 3;
        Assert.assertEquals(expectAnswer, ans);
    }
    @Test
    public void shouldReturn0When1Sub1() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Calculator calculator = new Calculator();
        int ans = calculator.compute(1, 1, "Sub");
        int expectAnswer = 0;
        Assert.assertEquals(expectAnswer, ans);
    }
    @Test
    public void shouldReturn2When2Mulit1() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Calculator calculator = new Calculator();
        int ans = calculator.compute(2, 1, "Mulit");
        int expectAnswer = 2;
        Assert.assertEquals(expectAnswer, ans);
    }
}