package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerModel {
    private final String computerNumber;

    public ComputerModel(List<Integer> computerNumber) {
        this.computerNumber = computerNumber.toString().replaceAll("[^0-9]","");
    }

    public Map<ScoreState, Integer> scoreCalculator(String playerNumber) {
        String computerNumber = this.computerNumber;
        Map<ScoreState, Integer> scoreMap = scoreMapInitialize(new HashMap<>());

        for (int i = 0; i < computerNumber.length(); ) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                scoreMap.put(ScoreState.STRIKE_SCORE,(scoreMap.get(ScoreState.STRIKE_SCORE) + 1));
                computerNumber = computerNumber.replace(String.valueOf(computerNumber.charAt(i)), "");
                playerNumber = playerNumber.replace(String.valueOf(playerNumber.charAt(i)), "");
                continue;
            }
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                scoreMap.put(ScoreState.BALL_SCORE, (scoreMap.get(ScoreState.BALL_SCORE) + 1));
            }
            i++;
        }
        return scoreMap;
    }

    private Map<ScoreState, Integer> scoreMapInitialize(Map<ScoreState, Integer> scoreMap) {
        scoreMap.put(ScoreState.BALL_SCORE, 0);
        scoreMap.put(ScoreState.STRIKE_SCORE, 0);
        return scoreMap;
    }
}
