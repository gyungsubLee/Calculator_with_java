package calculator.lv2.Adapter;

import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.*;

import java.util.HashMap;
import java.util.Map;

public class OperationAdapter implements Adapter {
    private final Map<OperatorEnum, Operation> operationMappingMap= new HashMap<>();

    public OperationAdapter() {
        initOperationMappingMap();
    }

    private void initOperationMappingMap(){
        operationMappingMap.put(OperatorEnum.ADD, new AddOperation());
        operationMappingMap.put(OperatorEnum.MINUS, new SubstractOperation());
        operationMappingMap.put(OperatorEnum.MULTIPLICATION, new MultiplyOperation());
        operationMappingMap.put(OperatorEnum.DIVISION, new DivideOperation());
    }

    @Override
    public Operation getOperation(OperatorEnum operatorType){
        return operationMappingMap.get(operatorType);
    }
}
