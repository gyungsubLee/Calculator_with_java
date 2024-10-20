package calculator.lv2.enums;

public enum OperatorEnum {
    ADD('+'),
    MINUS('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char symbol;

    OperatorEnum(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorEnum fromOperator(char operator){
        for(OperatorEnum type : OperatorEnum.values()){
            if(type.symbol == operator){
                return type;
            }
        }
       throw new UnsupportedOperationException("해당아는 연산자가 없습니다. " + operator);
    }

}
