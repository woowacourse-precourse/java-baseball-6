package baseball.view;

import static baseball.controller.BaseballController.GAME_END;
import static baseball.controller.BaseballController.GAME_RESTART;
import static baseball.controller.BaseballController.NUM_LENGTH;
import static baseball.utils.ErrorCode.*;
import static baseball.utils.Message.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class BaseballView {


    public static void printGameStartView() {
        System.out.println(START_GAME_MESSAGE.getMessage());
    }

    public static String chooseRestartGame() {
        String inputNum = Console.readLine();
        checkRestartNumValid(inputNum);
        return inputNum;
    }

    private static void checkRestartNumValid(String inputNum) {
        if (inputNum.equals(GAME_RESTART) || inputNum.equals(GAME_END)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_RESTART_NUM.getErrorCode());
    }

    public static List<Integer> getPlayerInput() {
        System.out.print(GET_PLAYER_INPUT.getMessage());
        List<String> inputstr = Arrays.asList(Console.readLine().split(""));
        List<Integer> input = inputstr.stream().map(Integer::parseInt).toList();
        checkInputValidation(input);
        return input;
    }

    private static void checkInputValidation(List<Integer> input) {
        if (isDuplicated(input)) {
            throw new IllegalArgumentException(DUPLICATED_GUESS_NUM.getErrorCode());
        }
        if (isInvalidLength(input)) {
            throw new IllegalArgumentException(INVALID_GUESS_NUM_LENGTH.getErrorCode());
        }
    }

    private static boolean isInvalidLength(List<Integer> input) {
        return input.size() != NUM_LENGTH;
    }

    private static boolean isDuplicated(List<Integer> input) {
        return input.size() != input.stream().distinct().count();
    }

    public static void printNothing() {
        System.out.println(PRINT_NOTHING.getMessage());
    }

    public static void printBall(int ballCount) {
        System.out.print(ballCount + PRINT_BALL.getMessage());
    }

    public static void printStrike(int strikeCount) {
        System.out.println(strikeCount + PRINT_STRIKE.getMessage());
    }

    public static void printWinGame() {
        System.out.println(WIN_GAME.getMessage());
        System.out.println(RESTART_GAME.getMessage());
    }

}
