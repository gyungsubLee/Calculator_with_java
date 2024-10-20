package calculator.lv2;


import calculator.lv2.Adapter.OperationHandler;
import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.*;
import calculator.lv2.repository.CalculationNumberRepository;

import java.util.Queue;

public class CalculatorImp implements Calculator {
    private final OperationHandler adapter;
    private final CalculationNumberRepository repository;

    public CalculatorImp(OperationHandler adapter, CalculationNumberRepository repository) {
        this.adapter = adapter;
        this.repository = repository;
    }

    // 계산
    @Override
    public double calculate(char operator, double a, double b){
        OperatorEnum operatorType = OperatorEnum.fromOperator(operator);
        Operation mappingOperation = adapter.getOperation(operatorType);

        if (mappingOperation == null) {
            throw new UnsupportedOperationException("Unknown operation: " + operator);
        }

        return mappingOperation.calculate(a, b);
    }

    // 저장
    @Override
    public void save(double number) {
        repository.saveNumber(number);
        System.out.println("계산한 결과 값인  '" + number + "' 가 저장 되었습니다.");
    }

    // 조회
    @Override
    public Queue<Double> getAll() {
        return repository.getNumberList();
    }

    // 삭제
    @Override
    public void remove() {
        double removeNumber = repository.removeNumber();// 맨 처음 요소 제거
        System.out.println("저장된 결과 값인  '" + removeNumber + "' 가 삭제 되었습니다.");
    }
}