package calculator.version3.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculationResultRepositoryImp implements CalculationResultRepository{
    private final Queue<Double> results = new LinkedList<>();

    @Override
    public void addResult(double result){
        results.add(result);
        System.out.println("계산한 결과 값인  '" + result + "' 가 저장 되었습니다.");
    }

    @Override
    public Queue<Double> getResults(){
        return results;
    }

    @Override
    public void removeResult() {
        Double removeNumber = results.remove();
        System.out.println("저장된 결과 값인  '" + removeNumber + "' 가 삭제 되었습니다.");
    }
}
