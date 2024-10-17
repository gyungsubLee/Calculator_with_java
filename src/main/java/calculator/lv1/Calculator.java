package calculator.lv1;

public class Calculator {

    // if 문
    public int calculate1(Character operator, int a, int b) {
        int answer = 0;

        if (operator.equals('+')) {
            answer = a + b;
        } else if (operator.equals('-')) {
            answer = a - b;
        } else if (operator.equals('*')) {
            answer = a * b;
        } else if (operator.equals('/')) {
            if(b==0) throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
            answer = a / b;
        } else {
            throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
        }
        return answer;
    }

    // switch 문
    public int calculate2(char operation, int a, int b) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': {
                try{
                    return a / b;
                } catch (ArithmeticException e){
                    throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
                }
            }
            default: throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
        }
    }

}
