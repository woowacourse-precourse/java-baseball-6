package baseball.service;

import baseball.domain.BaseballNumbers;

public class HintService {
    public String createHintMessage(BaseballNumbers computerNumber, BaseballNumbers inputNumber) {
        StringBuilder hintMsg = new StringBuilder();

        boolean isNothing = computerNumber.isNothing(inputNumber);
        int ballCount = computerNumber.getBallCount(inputNumber);
        int strikeCount = computerNumber.getStrikeCount(inputNumber);

        if (isNothing) {
            return "낫싱";
        }
        if (ballCount > 0) {
            hintMsg.append(ballCount).append("볼");
        }
        if (ballCount > 0 && strikeCount > 0) {
            hintMsg.append(" ");
        }
        if (strikeCount > 0) {
            hintMsg.append(strikeCount).append("스트라이크");
        }
        return hintMsg.toString();
    }

    public boolean isCorrect(BaseballNumbers computerNumber, BaseballNumbers inputNumber) {
        int strikeCount = computerNumber.getStrikeCount(inputNumber);
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }
}
