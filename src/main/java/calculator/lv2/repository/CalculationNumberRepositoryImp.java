package calculator.lv2.repository;

import java.util.LinkedList;
import java.util.Queue;

public class CalculationNumberRepositoryImp implements CalculationNumberRepository {
    private final Queue<Double> store = new LinkedList<>();

    @Override
    public void saveNumber(double number){
        store.add(number);
    }

    @Override
    public Queue<Double> getNumberList(){
        return store;
    }

    @Override
    public double removeNumber() {
        return store.remove();
    }
}
