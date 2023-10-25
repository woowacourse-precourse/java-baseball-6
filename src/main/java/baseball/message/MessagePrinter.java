package baseball.message;

import baseball.counter.StrikeBallCount;

import static baseball.message.Messages.*;

public class MessagePrinter {
    public static void printGameResultMessage(StrikeBallCount countStrikeAndBall) {
        System.out.println(generateGameResultMessage(countStrikeAndBall));
    }

    public static String generateGameResultMessage(StrikeBallCount countStrikeAndBall) {
        int strike = countStrikeAndBall.strike();
        int ball = countStrikeAndBall.ball();

        if (strike == 0 && ball == 0) {
            return RESULT_NOTHING;
        }

        if (strike == 3) {
            return RESULT_3_STRIKE;
        }

        StringBuilder message = new StringBuilder();

        if (ball > 0) {
            message.append(ball).append(BALL);
        }

        if (strike > 0) {
            if (ball > 0) {
                message.append(" ");
            }
            message.append(strike).append(STRIKE);
        }

        return message.toString();
    }

    public static void printGameStartMessage() {
        System.out.println(GAME_START);
    }

    public static void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBERS);
    }

    public static void printChooseRestartMessage() {
        System.out.print(CHOOSE_RESTART);
    }
}
