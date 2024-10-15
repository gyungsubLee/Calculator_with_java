package calculator.version3.operation;

public class DivideOperation implements Operation {

    @Override
    public double calculate(double a, double b) {
        if(b==0) throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
        return a / b;
    }
}
