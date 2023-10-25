package baseball.view;

import baseball.GameMessage;

import java.util.Map;

public class OutputView {
    static StringBuilder resultSb;
    public static void printStartGameMessage() {
        System.out.println(GameMessage.START_GAME_MESSAGE);
    }

    public static void printGameResultMessage(Map<String, Integer> result) {
        resultSb = new StringBuilder();

        if (result.containsKey(GameMessage.NOTHING.getMessage())
                && result.get(GameMessage.NOTHING.getMessage())
                == GameMessage.NOTHING_COUNT.getNumber()) {
            printNothing();
            return;
        }

        if (result.containsKey(GameMessage.BALL.getMessage())) {
            printBall(result);
        }

        if (result.containsKey(GameMessage.STRIKE.getMessage())) {
            printStrike(result);
        }

        System.out.println(resultSb);
    }

    private static void printNothing() {
        resultSb.append(GameMessage.NOTHING.getMessage());
        System.out.println(resultSb);
    }

    private static void printBall(Map<String, Integer> result) {
        resultSb.append(result.get(GameMessage.BALL.getMessage()))
                .append(GameMessage.BALL.getMessage())
                .append(GameMessage.BLANK.getMessage());
    }

    private static void printStrike(Map<String, Integer> result) {
        resultSb.append(result.get(GameMessage.STRIKE.getMessage()))
                .append(GameMessage.STRIKE.getMessage())
                .append(GameMessage.BLANK.getMessage());
    }

    public static void printThreeStrikeMessage() {
        System.out.println(GameMessage.THREE_STRIKE_MESSAGE.getMessage());
    }

    public static void printStartNewGameMessage() {
        System.out.println(GameMessage.NEW_GAME_START_MESSAGE.getMessage());
    }
}
