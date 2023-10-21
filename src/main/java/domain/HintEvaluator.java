package domain;

import java.util.List;

public class HintEvaluator {

    public String evaluate(List<Integer> computerNumbers, String userInput) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = Character.getNumericValue(userInput.charAt(i));

            if (computerNumber == userNumber) {
                strikeCount++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        if (strikeCount > 0 && ballCount > 0) {
            return strikeCount + "스트라이크 " + ballCount + "볼";
        }
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼";
    }
}
