/* version 3 */
import calculator.version3.Calculator;
import calculator.version3.CalculatorImp;
import calculator.version3.enums.InputEnum;
import calculator.version3.repository.CalculationResultRepository;
import calculator.version3.repository.CalculationResultRepositoryImp;

import java.util.Scanner;


public class Main {
    private Calculator calculator;
    private static CalculationResultRepository repository;

    public Main(Calculator calculator, CalculationResultRepository repository) {
        this.calculator = calculator;
        this.repository = repository;
    }

    public <T> T input(String message, Scanner sc, InputEnum type){
        System.out.print(message);
        Object input = null;

        switch (type){
            case NUMBER :
                if (sc.hasNextDouble()) {
                    input = sc.nextDouble();  // 소수점이 있는 숫자 또는 정수를 입력받음
                } else {
                    System.out.println("잘못된 숫자 입력입니다.");
                    sc.next();  // 잘못된 입력 제거
                }
                break;
            case OPERATOR:
                input = sc.next().charAt(0);  // 연산자 입력
                break;
            case EXIT:
                input = sc.next();  // 종료 문자열 입력
                break;
        }
        return (T) input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main(new CalculatorImp(), new CalculationResultRepositoryImp());

        double result = 0;

        double num1 = main.input("첫 번째 숫자를 입력하세요:", sc, InputEnum.NUMBER);
        double num2 = main.input("두 번째 숫자를 입력하세요:", sc, InputEnum.NUMBER);
        char operator = main.input("사칙연산 기호를 입력하세요: ", sc, InputEnum.OPERATOR);


        // 계산 반복
        Boolean isCalculating = false;
        while (isCalculating) {
            result = main.calculator.calculate(operator, num1, num2);
            System.out.println("현재 결과: " + result);

            // 추가 계산 여부 확인
            String continueInput = main.input("더 계산하시겠습니까? (exit 입력 시 종료): ", sc, InputEnum.EXIT);
            isCalculating = !continueInput.equalsIgnoreCase("exit");

            if (isCalculating) {
                double repeatNum = main.input("계산을 추가할 숫자를 입력하세요:", sc, InputEnum.NUMBER);
                char repeatOperator = main.input("추가 사칙연산 기호를 입력하세요: ", sc, InputEnum.OPERATOR);
                result = main.calculator.calculate(repeatOperator, result, repeatNum);
            }
        }

        System.out.println("최종 결과 값 = " + result);

        // 계산 결과 값 저장 및 조회
        repository.addResult(result);
        repository.getResults().forEach(n -> System.out.println("저장된 결과: " + n));

        // 삭제
        repository.removeResult();
        System.out.println("삭제 후 결과:");
        repository.getResults().forEach(n -> System.out.println("저장된 결과: " + n));
    }
}