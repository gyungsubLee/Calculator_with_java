/* version 3 */
import calculator.version3.Calculator;
import calculator.version3.CalculatorImp;

import java.util.Scanner;


public class Main {
    private static Calculator calculator;

    public Main(Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Main main = new Main(new CalculatorImp());


        System.out.print("첫 번째 숫자를 입력하세요:");
        double num1 = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요:");
        double num2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        Boolean isCalculationRepeat = false;

        double result = 0;

        //
        do {
            if(!isCalculationRepeat) {
                result = calculator.calculate(operator, num1, num2);
            } else {
                System.out.print("계산을 추가할 숫자를 입력하세요:");
                double repeatNum = sc.nextInt();

                System.out.print("추가 사칙연산 기호를 입력하세요: ");
                char repeatOperator = sc.next().charAt(0);

                double n = calculator.calculate(repeatOperator, result, repeatNum);
                result = n;

            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String s = sc.next();

            isCalculationRepeat = s.equals("exit")? false : true;

        }  while(isCalculationRepeat);


        System.out.println("결과 값 = " + result );
    }
}