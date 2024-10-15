package calculator.version2;

import calculator.version2.operation.AbstractOperation;


public class Calculator {

    private AbstractOperation operation;

    public Calculator(AbstractOperation operation) {
        this.operation = operation;
    }


    // Setter를 통해 operation 클래스 수정
    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    public double calculate(int a, int b) {
        double answer = 0;
        answer = operation.calculate(a, b);
        return answer;
    }

}