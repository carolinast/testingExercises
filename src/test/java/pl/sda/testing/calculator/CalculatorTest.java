package pl.sda.testing.calculator;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void whenAdding1And1_shouldReturn2() {
        int result = calculator.add(1, 1);

        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    @Ignore
    public void whenAdding1And1_shouldReturn3() {
        int result = calculator.add(1, 1);

        assertEquals(3, result);
    }

    @Test
    public void whenCheckingIf1IsEven_shouldReturnFalse() {
        //when
        boolean result = calculator.isEven(1);

        //then
        assertEquals(false, result);

    }

    @Test
    @Ignore
    public void whenCheckingIf2IsEven_shouldReturnFalse() {
        //when
        boolean result = calculator.isEven(2);
        //then
        assertEquals(false, result);

    }

    @Test
    public void whenCheckingIf5IsEven_shouldReturnFalse() {
        //when
        boolean result = calculator.isEven(5);
        //then
        assertFalse(result);
    }

    @Test
    public void whenMultiply2And2_shouldReturn4() {
        //when
        int result = calculator.multiply(2, 2);
        //then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @Ignore
    public void whenMultiply1And1_shouldReturn3() {
        //when
        int result = calculator.multiply(1, 1);
        //then
        assertEquals(3, result);
    }

    @Test
    public void whenDividing4By2_shouldReturn2() {
        //when
        double result = calculator.divide(4, 2);
        //then
        assertEquals(2d, result);
    }

    @Test
    public void whenSubstract1From2_shouldReturn1() {
        //when
        int result = calculator.substract(2, 1);
        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @Ignore
    public void whenAdding5And5_shouldReturn9() {
        //when
        int result = calculator.add(5, 5);
        //then
        Assertions.assertThat(result).as("Check if 5 plus 5 equals 10").isEqualTo(9);
    }

    @Test
    public void whenMakingFewOperations_shouldExistInCalculationsList() {
        //when
        calculator.add(9, 10);
        calculator.multiply(4, 4);
        calculator.substract(6, 3);
        List<String> list1 = Arrays.asList("9 + 10 = 19", "4 * 4 = 16", "6 - 3 = 3");
        //then
        assertThat(calculator.getCalculations())
                .contains("9 + 10 = 19")
                .doesNotContain("6 + 6 = 12")
                .containsAll(list1);
    }

    @Test
    public void whenMultiply_shouldReturnExpectedResultsFromList() {
        //when
        calculator.multiply(5, 5); //5 * 5 = 25
        //then
        Assertions.assertThat(calculator.getCalculations().get(0))
                .startsWith("5")
                .endsWith("25")
                .doesNotContain("-");

    }

    @Test
    public void whenNumbersAreNotPositive_shouldThrowIllegalArgumentException() {
        try {
            calculator.addPositive(-1, -1);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThat(e.getMessage()).isEqualTo("Argumenty muszą być większe od 0");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMultiplyNotEvenNumbers_shouldThrowIllegalArgumentException() {
        calculator.multiplyEven(3, 3);

    }

    @Test
    public void whenNumberIsLowerThen0_shouldIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Minimalna liczba to 0");

        calculator.factorial(-1);

    }

    @Test
    public void whenNumberIsGraterThenMax_shouldThrowNumberLimitExceeded() {
        exception.expect(Calculator.NumberLimitExceeded.class);
        exception.expectMessage("Maksymalna dozwolona liczba to: ");

        calculator.factorial(20);
    }

    @Test
    public void testExceptionFromFactorialMethod() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calculator.factorial(-5);
        })
                .withMessage("Minimalna liczba to 0");

    }

    @Test@Ignore
    public void testExceptionFromFactorialMethodNumberLimitExceeded() {
        assertThatExceptionOfType(Calculator.NumberLimitExceeded.class).isThrownBy(() -> {
            calculator.factorial(30);

        })
                .withMessage("Maksymalna dozwolona liczba to: ");
    }
//    @Test
//    @Parameters({"2, 2, 4", "3, 3, 27"})
//    public void testPow(int x, int y, int expected){
//
//        int result = calculator.pow(x,y);
//
//        Assertions.assertThat(result).isEqualTo(expected);
//    }

    @Test
    @FileParameters("scr/test/resources.csv")
    public void testPow(int o, int p, int expected){
        int result = calculator.pow(o, p);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
