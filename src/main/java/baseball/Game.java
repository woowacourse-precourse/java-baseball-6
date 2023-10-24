package baseball;

import baseball.message.GameMessage;
import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private InputValidator validator = new InputValidator();
    private Computer computer = new Computer();
    private User user = new User();

    public void start() {
        System.out.println(GameMessage.GAME_START.getMessage());
        while (true) {
            progress();

            if (!isRestart()) {
                break;
            }
        }
    }

    public void progress() {
        computer.setComputerRandNum();

        while (true) {
            System.out.print(GameMessage.USER_INPUT.getMessage());
            String input = Console.readLine();
            validator.validateInputNumber(input);
            user.setUserRandNum(input);

            GameResult result = computer.calculateResult(user.getUserRandNum());
            System.out.println(result.resultToString());

            if (result.isComplete()) {
                System.out.println(GameMessage.GAME_COMPLETE.getMessage());
                break;
            }
        }
    }

    public boolean isRestart() {
        System.out.println(GameMessage.GAME_RESTART.getMessage());
        String input = Console.readLine();
        validator.validateRestartChoice(input);

        if ("1".equals(input)) {
            return true;
        }

        return false;
    }
}
