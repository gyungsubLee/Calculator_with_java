package calculator.lv2;

import java.util.Queue;

public interface Calculator {

    double calculate(char operator, double a, double b);
    void save(double number);
    Queue<Double> getAll();
    void remove();


}
