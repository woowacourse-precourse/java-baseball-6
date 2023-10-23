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

    public Map<String, Integer> getResult(List<Integer> player) {
        init();
        for (int i = 0; i < player.size(); i++) {
            countScore(player, i);
        }

        return result;
    }

    private void init() {
        this.result = new HashMap<>() {{
            put(STRIKE, 0);
            put(BALL, 0);
        }};
    }

    private void countScore(List<Integer> player, Integer i) {
        Integer computerAnswer = computerNumbers.get(i);
        Integer playerAnswer = player.get(i);

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
