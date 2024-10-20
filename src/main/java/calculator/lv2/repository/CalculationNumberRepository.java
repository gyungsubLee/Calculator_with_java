package calculator.lv2.repository;

import java.util.Queue;

public interface CalculationNumberRepository {

    void saveNumber(double number);

    Queue<Double> getNumberList();
    double removeNumber();
}
