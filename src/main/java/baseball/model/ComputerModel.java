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
        Map<ScoreState, Integer> scoreMap = new HashMap<>();
        String computerNumber = this.computerNumber;
        scoreMap.put(ScoreState.BALL_SCORE, 0);
        scoreMap.put(ScoreState.STRIKE_SCORE, 0);
        int i = 0;

        while( i < computerNumber.length()) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                String sameNumber = String.valueOf(computerNumber.charAt(i));
                scoreMap.put(
                    ScoreState.STRIKE_SCORE,(scoreMap.get(ScoreState.STRIKE_SCORE) + 1));
                computerNumber = computerNumber.replace(sameNumber, "");
                playerNumber = playerNumber.replace(sameNumber, "");
                continue;
            }
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                scoreMap.put(ScoreState.BALL_SCORE, (scoreMap.get(ScoreState.BALL_SCORE) + 1));
            }
            i++;
        }
        return scoreMap;
    }
}
