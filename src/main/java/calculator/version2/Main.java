package calculator.version2;

import calculator.version2.operation.AddOperation;
import calculator.version2.operation.MultiplyOperation;

public class Main {
    public static void main(String[] args) {
        Calculator calculator  = new Calculator(new AddOperation());
        System.out.println(calculator.calculate(10, 20));
        calculator.setOperation(new MultiplyOperation());
        System.out.println(calculator.calculate(10, 20));
    }
}