import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void shouldReturn2When1Plus1() {
        Calculator calculator = new Calculator();
        int ans = calculator.compute(1, 2, '+');
        int expectAnswer = 3;
        Assert.assertEquals(expectAnswer, ans);
    }
    @Test
    public void shouldReturn2When1Sub1() {
        Calculator calculator = new Calculator();
        int ans = calculator.compute(1, 2, '-');
        int expectAnswer = 3;
        Assert.assertEquals(expectAnswer, ans);
    }
}