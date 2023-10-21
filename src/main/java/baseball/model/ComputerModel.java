package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerModel {
    private String computerNumber;

    public ComputerModel(List<Integer> computerNumber) {
        this.computerNumber = computerNumber.toString();
    }

    public Map<String, Integer> scoreCalculator(String playerNumber) {
        Map<String, Integer> scoreCounter = new HashMap<String, Integer>();
        String computerNumber = this.computerNumber;
        scoreCounter.put("ballScore", 0);
        scoreCounter.put("strikeScore", 0);

        for (int i = 0; i < computerNumber.length(); i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                String sameNumber = String.valueOf(computerNumber.charAt(i));
                scoreCounter.put("strikeScore",(scoreCounter.get("strikeScore") + 1));
                computerNumber = computerNumber.replace(sameNumber, "");
                playerNumber = playerNumber.replace(sameNumber, "");
                i--;
            }
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                scoreCounter.put("ballScore",(scoreCounter.get("ballScore") + 1));
            }
        }
        return scoreCounter;
    }
}
