package baseball.domain;

import baseball.io.OutputConsole;

import java.util.List;

public class GameResult {

    public static Result getResult(List<Integer> computerNumber, List<Integer> inputNumber) {
        Message hintMessage = getHintMessage(computerNumber, inputNumber);

        OutputConsole.println(hintMessage.getMessage());
        if (hintMessage == Message.THREE_STRIKE) {
            return Result.CORRECT;
        }

        return Result.WRONG;
    }

    private static Message getHintMessage(List<Integer> computerNumber, List<Integer> inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = 0; j < inputNumber.size(); j++) {
                if (i == j && computerNumber.get(i).equals(inputNumber.get(j))) {
                    strikeCount++;
                }

                if (i != j && computerNumber.get(i).equals(inputNumber.get(j))) {
                    ballCount++;
                }
            }
        }

        return mappingHintMessage(ballCount, strikeCount);
    }

    private static Message mappingHintMessage(int ballCount, int strikeCount) {
        if (ballCount == 1 && strikeCount == 0) {
            return Message.ONE_BALL;
        }
        if (ballCount == 1 && strikeCount == 1) {
            return Message.ONE_BALL_ONE_STRIKE;
        }
        if (ballCount == 1 && strikeCount == 2) {
            return Message.ONE_BALL_TWO_STRIKE;
        }
        if (ballCount == 2 && strikeCount == 0) {
            return Message.TWO_BALL;
        }
        if (ballCount == 2 && strikeCount == 1) {
            return Message.TWO_BALL_ONE_STRIKE;
        }
        if (ballCount == 3 && strikeCount == 0) {
            return Message.THREE_BALL;
        }
        if (ballCount == 0 && strikeCount == 1) {
            return Message.ONE_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 2) {
            return Message.TWO_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 3) {
            return Message.THREE_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 0) {
            return Message.NOTHING;
        }

        throw new IllegalArgumentException("힌트 메시지에 오류가 발생하였습니다.");
    }
}
