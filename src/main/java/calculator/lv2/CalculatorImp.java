package calculator.lv2;


import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.*;

import java.util.HashMap;
import java.util.Map;

// • 추상 메서드 -> 인터페이스
// • 어댑터 패턴 적용
public class CalculatorImp implements Calculator {
    private final Map<OperatorEnum, Operation> operationMappingAapter = new HashMap<>();

    public CalculatorImp() {
        initOperationMappingMap();
    }

    private void initOperationMappingMap(){
        operationMappingAapter.put(OperatorEnum.ADD, new AddOperation());
        operationMappingAapter.put(OperatorEnum.MINUS, new SubstractOperation());
        operationMappingAapter.put(OperatorEnum.MULTIPLICATION, new MultiplyOperation());
        operationMappingAapter.put(OperatorEnum.DIVISION, new DivideOperation());
    }


    @Override
    public double calculate(char operator, double a, double b){
        OperatorEnum operatorType = OperatorEnum.fromOperator(operator);
        Operation mappingOperation = operationMappingAapter.get(operatorType);

        if (mappingOperation == null) {
            throw new UnsupportedOperationException("Unknown operation: " + operator);
        }

        return mappingOperation.calculate(a, b);
    }
}