package calculator.lv2.Adapter;

import calculator.lv2.Factory;
import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.*;

import java.util.HashMap;
import java.util.Map;

public class OperationHandler implements Handler {
    private final Map<OperatorEnum, Operation> operationMappingMap= new HashMap<>();

    public OperationHandler() {
        initOperationMappingMap();
    }

    private void initOperationMappingMap(){
        for (OperatorEnum operatorEnum : OperatorEnum.values()) {
            operationMappingMap.put(operatorEnum, Factory.createOperation(operatorEnum));
        }
    }

    @Override
    public Operation getOperation(OperatorEnum operatorType){
        return operationMappingMap.get(operatorType);
    }
}
