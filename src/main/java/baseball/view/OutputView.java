package baseball.view;

import baseball.common.GameValue;
import baseball.dto.CountResultDto;

public class OutputView {
    private final static String DELIMITER = " ";

    private OutputView() {
    }

    public static void printResult(CountResultDto countResultDto) {
        int strikeCount = countResultDto.getStrikeCount();
        int ballCount = countResultDto.getBallCount();
        if (strikeCount == ballCount && strikeCount > GameValue.ZERO.getValue()) {
            System.out.println(strikeCount + GameMessage.STRIKE.getMessage());
            return;
        }
        if (strikeCount == GameValue.ZERO.getValue() && ballCount > GameValue.ZERO.getValue()) {
            System.out.println(ballCount + GameMessage.BALL.getMessage());
            return;
        }
        if (strikeCount > GameValue.ZERO.getValue() && ballCount - strikeCount > GameValue.ZERO.getValue()) {
            String ballMessage = (ballCount - strikeCount) + GameMessage.BALL.getMessage();
            String strikeMessage = strikeCount + GameMessage.STRIKE.getMessage();
            System.out.println(String.join(DELIMITER, ballMessage, strikeMessage));
            return;
        }
        System.out.println(GameMessage.NOTHING.getMessage());
    }

    public static void printGameStartMessage() {
        System.out.println(GameMessage.START_GAME.getMessage());
    }

    public static void printRetryMessage() {
        System.out.println(GameMessage.ASK_RETRY.getMessage());
    }

    public static void printInputMessage() {
        System.out.print(GameMessage.INPUT_NUMBER.getMessage());
    }

    public static void printWinGameMessage() {
        System.out.println(GameMessage.SUCCESS.getMessage());
    }
}
