package pl.sda.testing.calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class CalculatorAddTest {
    private Calculator calculator = new Calculator();
    private int x;
    private int y;
    private int expected;


    public CalculatorAddTest(int x, int y, int expected) {
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Test add {0} + {1} = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {3, 3, 6}
        });
    }

    @Test
    public void whenAdding_shouldReturnResult() {
        int result = calculator.add(x, y);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
