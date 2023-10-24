package baseball.play;

import static baseball.util.Constant.CHECK_END_MSG;
import static baseball.util.Constant.CHOICE_ERR_MSG;
import static baseball.util.Constant.CORRECT_MSG;
import static baseball.util.Constant.END_MSG;
import static baseball.util.Constant.START_GAME_MSG;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Hint hint;

    public Game() {
        hint = new Hint();
    }

    public void start() {
        System.out.println(START_GAME_MSG);

        boolean playAgain = true;

        while (playAgain) {
            playGame();
            System.out.println(CHECK_END_MSG);
            playAgain = getUserChoice();
        }

        System.out.println(END_MSG);
    }

    private void playGame() {
        Computer computer = new Computer();
        Player player = new Player();
        int attempts = 0;

        while (true) {
            player.inputUserNumber();
            String result = hint.evaluateGuess(player, computer);
            System.out.println(result);
            attempts++;

            if (result.equals("3스트라이크")) {
                System.out.println(attempts + CORRECT_MSG);
                break;
            }
        }
    }

    private boolean getUserChoice() {
        while (true) {
            String input = Console.readLine();
            if ("1".equals(input)) {
                return true;
            }
            if ("2".equals(input)) {
                return false;
            }
            System.out.println(CHOICE_ERR_MSG);
        }
    }
}
