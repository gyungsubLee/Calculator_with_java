package calculator.lv2.operation;

public class AddOperation implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
