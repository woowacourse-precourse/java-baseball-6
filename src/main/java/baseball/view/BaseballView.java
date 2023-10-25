package baseball.view;

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
        return inputNum;
    }

    public static List<Integer> getPlayerInput() {
        System.out.print(GET_PLAYER_INPUT.getMessage());
        List<String> inputstr = Arrays.asList(Console.readLine().split(""));
        List<Integer> input = inputstr.stream().map(Integer::parseInt).toList();
        return input;
    }

    public static void printNothing() {
        System.out.println(PRINT_NOTHING.getMessage());
    }

    public static void printBall(int ballCount) {
        System.out.println(ballCount + PRINT_BALL.getMessage());
    }

    public static void printStrike(int strikeCount) {
        System.out.println(strikeCount + PRINT_STRIKE.getMessage());
    }

    public static void printWinGame() {
        System.out.println(WIN_GAME.getMessage());
        System.out.println(RESTART_GAME.getMessage());
    }

    public BaseballView() {
    }
}
