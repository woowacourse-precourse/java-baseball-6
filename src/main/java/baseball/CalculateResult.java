package baseball;

import java.util.List;

public class CalculateResult {
    public static String calculateResult(List<Integer> answer, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (answer.contains(userGuess.get(i))) {
                balls++;
            }
        }

        String result = "";

        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크 ";
        }
        if (balls == 0 && strikes == 0) {
            result = "낫싱";
        }

        return result.trim(); // 공백을 제거
    }
}
