package baseball;

import baseball.constants.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.ConsoleMessage.*;
import static baseball.constants.Rule.GAME_END;
import static baseball.constants.Rule.GAME_RESTART;

public class Console {
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printSuccessEndMessage() {
        System.out.println(SUCCESS_END_MESSAGE);
    }

    public static void printGameRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }

    public static void printResult(int ballCount, int strikeCount) {
        ArrayList<String> result = new ArrayList<>();

        if (ballCount > 0) {
            result.add(String.format(BALL_COUNT_MESSAGE, ballCount));
        }
        if (strikeCount > 0) {
            result.add(String.format(STRIKE_COUNT_MESSAGE, strikeCount));
        }

        System.out.println(result.isEmpty() ? NOTHING_MESSAGE : String.join(" ", result));
    }

    private static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static String readNumbers() {
        String input = readLine();
        if (input.chars().anyMatch(ch -> ch < '1' || ch > '9')) {
            throw new IllegalArgumentException(ErrorMessage.ONE_TO_NINE);
        } else if (input.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.THREE_DIGITS);
        } else if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DISTINCT);
        }

        return input;
    }

    public static String readRestartOrEnd() {
        String input = readLine();
        if (!List.of(GAME_RESTART, GAME_END).contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_OR_TWO);
        }
        return input;
    }
}
