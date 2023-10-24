package baseball.model;

import baseball.utils.Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final List<Integer> computerNumbers;
    private final String BALL = Score.BALL.getResult();
    private final String STRIKE = Score.STRIKE.getResult();
    private Map<String, Integer> result;

    public Result(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public Map<String, Integer> getResult(List<Integer> playerNumbers) {
        init();
        for (int i = 0; i < playerNumbers.size(); i++) {
            compareComputer(playerNumbers, i);
        }
        return result;
    }

    private void init() {
        this.result = new HashMap<>() {{
            put(STRIKE, 0);
            put(BALL, 0);
        }};
    }

    private void compareComputer(List<Integer> playerNumbers, Integer i) {
        Integer computerAnswer = computerNumbers.get(i);
        Integer playerAnswer = playerNumbers.get(i);

        if(isStrike(computerAnswer, playerAnswer)) {
            result.put(STRIKE, result.get(STRIKE)+1);
        }

        if(isBall(computerAnswer, playerAnswer)) {
            result.put(BALL, result.get(BALL)+1);
        }
    }

    private boolean isStrike(Integer computerNum, Integer playerNum) {
        return Objects.equals(computerNum, playerNum);
    }

    private boolean isBall(Integer computerNum, Integer playerNum) {
        return computerNumbers.contains(playerNum) &&
                !Objects.equals(computerNum, playerNum);
    }
}
