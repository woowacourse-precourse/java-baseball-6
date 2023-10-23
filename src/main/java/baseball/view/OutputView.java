package baseball.view;

import baseball.dto.CountResultDto;

public class OutputView {
    private final static String DELIMITER = " ";

    private OutputView() {
    }

    public static String printResult(CountResultDto countResultDto) {
        int strikeCount = countResultDto.getStrikeCount();
        int ballCount = countResultDto.getBallCount();
        if (strikeCount == ballCount && strikeCount > GameValue.ZERO.getValue()) {
            return strikeCount + GameMessage.STRIKE.getMessage();
        }
        if (strikeCount == GameValue.ZERO.getValue() && ballCount > GameValue.ZERO.getValue()) {
            return ballCount + GameMessage.BALL.getMessage();
        }
        if (strikeCount > GameValue.ZERO.getValue() && ballCount - strikeCount > GameValue.ZERO.getValue()) {
            String ballMessage = (ballCount - strikeCount) + GameMessage.BALL.getMessage();
            String strikeMessage = strikeCount + GameMessage.STRIKE.getMessage();
            return String.join(DELIMITER, ballMessage, strikeMessage);
        }
        return GameMessage.NOTHING.getMessage();
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
