package baseball.io;

import static baseball.io.IOMessage.BALL;
import static baseball.io.IOMessage.NOTHING;
import static baseball.io.IOMessage.STRIKE;

import baseball.domain.Result;

public class Output {

    public static boolean printResult(Result result) {

        int strike = result.getStrike();
        int ball = result.getBall();
        StringBuilder print = new StringBuilder();

        if (strike + ball == 0) {
            print.append(NOTHING.getMessage());
        }
        if (ball + strike != 0) {
            print.append(renderSB(ball, BALL));
            print.append(renderSB(strike, STRIKE));
        }
        System.out.println(print.toString().trim());
        // false가 나오면 GameController에 Recursive 함수 중단.
        return strike < 3;
    }

    public static void printGameBegin() {
        System.out.println(IOMessage.GAME_BEGIN.getMessage());
    }

    public static void printGameEnd() {
        System.out.println(IOMessage.GAME_END.getMessage());
    }

    public static void printTryNumber() {
        System.out.println(IOMessage.TRY_NUMBER.getMessage());
    }

    public static void printGameAgain() {
        System.out.println(IOMessage.GAME_AGAIN.getMessage());
    }

    public static void printWinGame() {
        System.out.println(IOMessage.WIN_GAME.getMessage());
    }

    private static String renderSB(int resultValue, IOMessage message) {
        return switch (resultValue) {
            case 0 -> "";
            default -> resultValue + message.getMessage() + " ";
        };
    }
}