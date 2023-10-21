package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerModel {
    private final String computerNumber;

    public ComputerModel(List<Integer> computerNumber) {
        this.computerNumber = computerNumber.toString();
    }

    public Map<String, Integer> scoreCalculator(String playerNumber) {
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        String computerNumber = this.computerNumber;
        scoreMap.put("ballScore", 0);
        scoreMap.put("strikeScore", 0);

        for (int i = 0; i < computerNumber.length(); i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                String sameNumber = String.valueOf(computerNumber.charAt(i));
                scoreMap.put("strikeScore",(scoreMap.get("strikeScore") + 1));
                computerNumber = computerNumber.replace(sameNumber, "");
                playerNumber = playerNumber.replace(sameNumber, "");
                i--;
            }
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                scoreMap.put("ballScore",(scoreMap.get("ballScore") + 1));
            }
        }
        return scoreMap;
    }
}
