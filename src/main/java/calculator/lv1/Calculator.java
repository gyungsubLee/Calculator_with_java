package calculator.lv1;

import java.util.Scanner;


// 피드백) 클래스 합침, 요구사항 준수
class Calculator {
    // if 문
    public int calculate1(Character operator, int a, int b) {
        if (operator.equals('+')) {
            return a + b;
        } else if (operator.equals('-')) {
            return a - b;
        } else if (operator.equals('*')) {
            return a * b;
        } else if (operator.equals('/')) {
            if(b==0) throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
            return a / b;
        } else {
            throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
        }
    }

    // switch 문
    public int calculate2(char operation, int a, int b) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': {
                // 피드백) 요구 사항에 준수
                if(b==0) throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
                return a / b;
            }
            default: throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("첫 번째 숫자를 입력하세요:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);
        Boolean isCalculationRepeat = false;
        int result = 0;

        // 반복 게산, do-catch문 연습해봄
        do {
            if(!isCalculationRepeat) {
                result = calculator.calculate1(operator, num1, num2);
            } else {
                System.out.print("계산을 추가할 숫자를 입력하세요:");
                int repeatNum = sc.nextInt();
                System.out.print("추가 사칙연산 기호를 입력하세요: ");
                char repeatOperator = sc.next().charAt(0);
                int n = calculator.calculate1(repeatOperator, result, repeatNum);
                result = n;
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String s = sc.next();

            /**
             * 피드백
             * equals() 사용 시, NullpointException이 발생될 수 있기 떄문에
             *  상수보다는 '변수'를 인자값으로 넘김
             */
            isCalculationRepeat = ("exit").equals(s)? false : true;
        }  while(isCalculationRepeat);
        System.out.println("결과 값 = " + result );
    }
}