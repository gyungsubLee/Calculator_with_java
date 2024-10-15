package calculator.Step1_2;

public class Calculator {

    // if 문
    public double calculate1(String operator, int firstNumber, int secondNumber) {
        double answer = 0;

        if (operator.equals("+")) {
            answer = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            answer = firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            answer = firstNumber * secondNumber;
        } else if (operator.equals("/")) {
            answer = firstNumber / secondNumber;
        } else if (operator.equals("%")) {    // else 문 가능, 더 명시적으로 표현하기 위해 else if 사용
            answer = firstNumber % secondNumber;
        }
        return answer;
    }

    // switch 문
    public double calculate2(String operation, double a, double b) {
        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "%": return a % b;
            default: throw new UnsupportedOperationException("Unknown operation");
        }
    }

}
