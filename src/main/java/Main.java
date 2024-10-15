
/* version 1 */
//import calculator.version1.Calculator;

/* version 2 */
//import calculator.version2.operation.AddOperation;
//import calculator.version2.operation.MultiplyOperation;

/* version 3 */
import calculator.version3.Calculator;


import calculator.version3.Calculator;

public class Main {
    public static void main(String[] args) {

        // version1
//        Calculator calculator  = new Calculator();
//        System.out.println(calculator.calculate1("+", 10, 20));
//        System.out.println(calculator.calculate2("+", 10, 20));

        // version2
//        calculator.version2.Calculator calculator  = new calculator.version2.Calculator(new AddOperation());
//        System.out.println(calculator.calculate(10, 20));
//        calculator.setOperation(new MultiplyOperation());
//        System.out.println(calculator.calculate(10, 20));

        // vertion3
        Calculator calculator  = new Calculator();

        System.out.println("Addition: " + calculator.calculate("+", 10, 20)); // 30
        System.out.println("Subtraction: " + calculator.calculate("-", 20, 10)); // 10
        System.out.println("Multiplication: " + calculator.calculate("*", 10, 20)); // 200
        System.out.println("Division: " + calculator.calculate("/", 20, 10)); // 2

    }
}