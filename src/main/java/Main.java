/* version 3 */
import calculator.version3.Calculator;
import calculator.version3.CalculatorImp;

import java.util.Scanner;


public class Main {
    private static Calculator calculator;

    public Main(Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main main = new Main(new CalculatorImp());

        System.out.println("Addition: " + calculator.calculate("+", 10, 20)); // 30
        System.out.println("Subtraction: " + calculator.calculate("-", 20, 10)); // 10
        System.out.println("Multiplication: " + calculator.calculate("*", 10, 20)); // 200
        System.out.println("Division: " + calculator.calculate("/", 20, 10)); // 2

    }
}