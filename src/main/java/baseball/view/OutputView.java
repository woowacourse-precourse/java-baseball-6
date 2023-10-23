package baseball.view;

import baseball.common.GameValue;
import baseball.dto.CountResultDto;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final static String DELIMITER = " ";

    private OutputView() {
    }

    public static void printResult(CountResultDto countResultDto) {
        int strikeCount = countResultDto.getStrikeCount();
        int ballCount = countResultDto.getBallCount();
        List<String> result = new ArrayList<>();
        if (ballCount != 0) {
            result.add(ballCount + GameMessage.BALL.getMessage());
        }
        if (strikeCount != 0) {
            result.add(strikeCount + GameMessage.STRIKE.getMessage());
        }
        if (strikeCount == GameValue.ZERO.getValue() && ballCount == GameValue.ZERO.getValue()) {
            result.add(GameMessage.NOTHING.getMessage());
        }
        System.out.println(String.join(DELIMITER, result));
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
