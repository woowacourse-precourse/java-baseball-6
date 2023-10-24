package baseball.model;

import java.util.List;
import java.util.Map;

public class Computer {
    private final Result result;

    public Computer(List<Integer> computerNumbers) {
        this.result = new Result(computerNumbers);
    }

    public Map<String, Integer> getResult(List<Integer> playerNumbers) {
        return  result.getResult(playerNumbers);
    }
}
