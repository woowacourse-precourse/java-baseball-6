package baseball.service;

import baseball.domain.BaseballNumbers;

public class HintService {
    public String createHintMessage(BaseballNumbers computerNumber, BaseballNumbers inputNumber) {
        String hintMsg = "";

        boolean isNothing = computerNumber.isNothing(inputNumber);
        int ballCount = computerNumber.getBallCount(inputNumber);
        int strikeCount = computerNumber.getStrikeCount(inputNumber);

        if (isNothing) {
            return "낫싱";
        }
        if (ballCount > 0) {
            hintMsg += ballCount + "볼";
        }
        if (ballCount > 0 && strikeCount > 0) {
            hintMsg += " ";
        }
        if (strikeCount > 0) {
            hintMsg += strikeCount + "스트라이크";
        }
        return hintMsg;
    }
}
