package calculator.lv2.operation;

public class SubstractOperation implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
