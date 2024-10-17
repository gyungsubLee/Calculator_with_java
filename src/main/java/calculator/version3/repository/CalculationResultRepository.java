package calculator.version3.repository;

import java.util.Queue;

public interface CalculationResultRepository {
    void addResult(double result);
    Queue<Double> getResults();
    void removeResult();
}
