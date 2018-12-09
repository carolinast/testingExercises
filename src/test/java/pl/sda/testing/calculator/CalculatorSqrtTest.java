package pl.sda.testing.calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class CalculatorSqrtTest {

    private Calculator calculator = new Calculator();

    private int x;
    private int expected;


    public CalculatorSqrtTest(int x, int expected) {
        this.x = x;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "SqrtTest{0} = {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 1},
                {9, 3}
        });
    }

    @Test
    public void TestShouldShowSqrtNumbersFromX() {

        int result = (int) calculator.sqrt(x);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
