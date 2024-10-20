package calculator.lv2.Adapter;

import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.Operation;

public interface Adapter {

    public Operation getOperation(OperatorEnum operatorType);
}
