package calculator.lv2;

import calculator.lv2.Adapter.OperationHandler;
import calculator.lv2.enums.OperatorEnum;
import calculator.lv2.operation.*;
import calculator.lv2.repository.CalculationNumberRepositoryImp;

public class Factory {

    public static Calculator createCalculator() {
        return new CalculatorImp(new OperationHandler(), new CalculationNumberRepositoryImp());
    }

   public static Operation createOperation(OperatorEnum type){
        if(type == OperatorEnum.ADD){
            return new AddOperation();
        } else if(type == OperatorEnum.ADD){
            return new SubstractOperation();
        }  else if(type == OperatorEnum.ADD){
            return new MultiplyOperation();
        }  else {
            return new DivideOperation();
        }
   }
}