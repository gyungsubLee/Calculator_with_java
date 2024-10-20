import calculator.lv2.Adapter.OperationHandler;
import calculator.lv2.Calculator;
import calculator.lv2.CalculatorImp;
import calculator.lv2.Factory;
import calculator.lv2.enums.InputEnum;
import calculator.lv2.repository.CalculationNumberRepositoryImp;

import java.util.Scanner;


public class App {
    // 각 타입 별로 입력 메세지 및 입력값 받아오는 메서드
    public static <T>T input(String message, Scanner sc, InputEnum type){
        System.out.print(message);
        return switch (type){
            case NUMBER -> (T) Double.valueOf(sc.nextDouble());
            case OPERATOR -> (T)  Character.valueOf(sc.next().charAt(0));
            case EXIT -> (T)  String.valueOf(sc.next());
        };
    }

    // 첫번째 계산을 수행하는 메서드
    public static double performCalculation(Scanner sc, Calculator calculator){
        double result = input("첫 번째 숫자를 입력하세요:", sc, InputEnum.NUMBER);
        char operator = input("사칙연산 기호를 입력하세요: ", sc, InputEnum.OPERATOR);
        double num2 = input("두 번째 숫자를 입력하세요:", sc, InputEnum.NUMBER);
        return  calculator.calculate(operator, result, num2);
    }

    // 추가 계산을 수행하는 메서드, 오버로딩
    public static double performCalculation(Scanner sc, Calculator calculator, double result) {
        double repeatNum = input("계산을 추가할 숫자를 입력하세요:", sc, InputEnum.NUMBER);
        char repeatOperator = input("추가 사칙연산 기호를 입력하세요: ", sc, InputEnum.OPERATOR);
        return calculator.calculate(repeatOperator, result, repeatNum);
    }

    // 추가 계산 여부 판단 메서드
    public static boolean shouldContinue(Scanner sc) {
        String continueInput = input("더 계산하시겠습니까? ( NO 입력 시 종료): ", sc, InputEnum.EXIT);
        return !continueInput.equalsIgnoreCase("NO");  // 대소문자 구분 X
    }


    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Factory에서 의존성이 생성하여 가져옴
        Calculator calculator = Factory.createCalculator();

        // 첫 번째 계산 수행
        double result = performCalculation(sc, calculator);

        // 추가 계산 여부 확인 및 반복 수행
        while (shouldContinue(sc)) {
            result = performCalculation(sc, calculator, result);
        }

        System.out.println("최종 결과 값 = " + result);

        // 계산 결과 저장 및 출력
        calculator.save(result); // 저장
        for (double n : calculator.getAll()) {
            System.out.println(n);
        }

        // 결과 삭제 후 전체 조회
        calculator.remove();
        for (double n : calculator.getAll()) {
            System.out.println(n);
        }
    }
}