package baseball.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int number = pickNumberInRange(1, 9);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    private Map<String, Integer> getBallAndStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        Map<String, Integer> ballAndStrikeCount = new HashMap<>();
        ballAndStrikeCount.put("ballCount", 0);
        ballAndStrikeCount.put("strikeCount", 0);
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i)) && computerNumber.get(i) != userNumber.get(i)) {
                ballAndStrikeCount.put("ballCount", ballAndStrikeCount.get("ballCount") + 1);
            }
            if (computerNumber.get(i) == userNumber.get(i)) {
                ballAndStrikeCount.put("strikeCount", ballAndStrikeCount.get("strikeCount") + 1);
            }
        }
        return ballAndStrikeCount;
    }

    private String getResultMessage(Map<String, Integer> ballAndStrikeCount) {
        String resultMessage = new String();
        if (ballAndStrikeCount.get("ballCount") == 0 && ballAndStrikeCount.get("strikeCount") == 0) {
            resultMessage = "낫싱";
        }
        if (ballAndStrikeCount.get("ballCount") == 0 && ballAndStrikeCount.get("strikeCount") != 0) {
            resultMessage = ballAndStrikeCount.get("strikeCount") + "스트라이크";
        }
        if (ballAndStrikeCount.get("ballCount") != 0 && ballAndStrikeCount.get("strikeCount") == 0) {
            resultMessage = ballAndStrikeCount.get("ballCount") + "볼";
        }
        if (ballAndStrikeCount.get("ballCount") != 0 && ballAndStrikeCount.get("strikeCount") != 0) {
            resultMessage = ballAndStrikeCount.get("ballCount") + "볼 " + ballAndStrikeCount.get("strikeCount") + "스트라이크";
        }
        return resultMessage;
    }
}
