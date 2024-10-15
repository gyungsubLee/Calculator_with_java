package calculator.version3;


import calculator.version3.operation.*;

import java.util.HashMap;
import java.util.Map;

// Step 5
// • 추상 메서드 -> 인터페이스
// • 어댑터 패턴 적용
public class Calculator {
    private final Map<String, Operation> operationMappingAapter = new HashMap<>();

    public Calculator() {
        initOperationMappingMap();
    }

    private void initOperationMappingMap(){
        operationMappingAapter.put("+", new AddOperation());
        operationMappingAapter.put("-", new SubstractOperation());
        operationMappingAapter.put("*", new MultiplyOperation());
        operationMappingAapter.put("/", new DivideOperation());
    }

    public double calculate(String operator, double a, double b){
        Operation mappingOperation = operationMappingAapter.get(operator);
        if (mappingOperation == null) {
            throw new UnsupportedOperationException("Unknown operation: " + operator);
        }
        return mappingOperation.calculate(a, b);
    }
}