package baseball.game;

import baseball.constants.Message;
import baseball.input.InputHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameRunner {

    public static Game game;

    private GameRunner() {

    }

    private static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static void gameStart() {
        System.out.println(Message.START_MSG);
    }

    public static void makeNumbers() {
        game = getInstance();
    }

    public static List<Integer> readInput() {
        System.out.print(Message.INPUT_MSG);
        String input = Console.readLine();
        return InputHandler.inputToList(input);
    }

    public static void count(List<Integer> user) {
        game.count(user);
    }

    public static void printResult() {
        System.out.println(game.getResultString());
    }

    public static boolean isEnd() {
        if (game.is3Strike()) {
            System.out.println(Message.SUCCESS_MSG);
            String input = Console.readLine();
            if (InputHandler.checkRestartInput(input)) {
                game = null;
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
