package pl.sda.testing.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final int MAX = 10;
    private List<String> calculations = new ArrayList<String>();

    public List<String> getCalculations() {
        return calculations;
    }

    public int add(int x, int y) {
        int result = x + y;
        calculations.add(String.format("%d + %d = %d", x, y, result));

        return result;
    }

    public boolean isEven(int x) {
        boolean result = x % 2 == 0;

        calculations.add(String.format("isEven %d = %s", x, result));

        return result;
    }

    public int substract(int x, int y) {
        int result = x - y;
        calculations.add(String.format("%d - %d = %d", x, y, result));

        return result;
    }

    public int multiply(int x, int y) {
        int result = x * y;
        calculations.add(String.format("%d * %d = %d", x, y, result));

        return result;
    }

    public double divide(int x, int y) {
        if (y == 0)
            throw new ArithmeticException("Cannot divide by 0");

        double result = (double) x / y;
        calculations.add(String.format("%d / %d = %.2f", x, y, result));

        return result;
    }

    public int addLimited(int x, int y) {
        if (x > MAX || y > MAX)
            throw new NumberLimitExceeded("Maksymalna dozwolona liczba to: " + MAX);

        return add(x, y);
    }

    public int addPositive(int x, int y) {
        if (x <= 0 || y <= 0)
            throw new IllegalArgumentException("Argumenty muszą być większe od 0");

        return add(x, y);
    }

    public int multipleEven(int x, int y) {
        if (x % 2 != 0 || y % 2 != 0)
            throw new IllegalArgumentException("Argumenty muszą być liczbami parzystymi");
        return multiply(x, y);
    }

    public int factorial(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Minimalna liczba to 0");
        if (x > MAX)
            throw new NumberLimitExceeded("Maksymalna dozwolona liczba to: " + MAX);

        if (x < 1)
            return 1;

        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }

        return result;
    }

    public int pow(int x, int y) {
        return (int) Math.pow(x, y);
    }

    public double sqrt(int x) {
        return Math.sqrt(x);
    }

    public class NumberLimitExceeded extends RuntimeException {
        public NumberLimitExceeded(String message) {
            super(message);
        }
    }
}
