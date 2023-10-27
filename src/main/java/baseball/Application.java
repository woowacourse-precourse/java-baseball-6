package baseball;

import baseball.game.Game;
import baseball.message.Message;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Message.FIRST_GAME_START);
        do {
            Game game = new Game();
            game.start();
            System.out.println(Message.GAME_END);
        } while (isRestart());
    }

    private static boolean isRestart() {
        final String RESTART_INPUT_REGEX = "[12]";

        String input = Console.readLine();
        if (!input.matches(RESTART_INPUT_REGEX)) {
            throw new IllegalArgumentException();
        }

        if (input.equals("1")) {
            return true;
        }

        return false;
    }
}
