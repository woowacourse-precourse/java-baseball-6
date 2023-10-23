package baseball.domain;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameControlMessage.*;
import static baseball.constant.GameStatus.CONTINUE_GAME_STATUS;
import static baseball.constant.GameStatus.END_GAME_STATUS;

public class BaseBallGame {

    public void play() {
        System.out.println(START_GAME_MESSAGE);

        int game_status = CONTINUE_GAME_STATUS;
        while (game_status == CONTINUE_GAME_STATUS) {
            game_status = game();
        }
    }

    private int game() {
        InputValidator validator = new InputValidator();
        ComputerNumber computer = new ComputerNumber();

        System.out.print(NEED_GAME_INPUT_MESSAGE);

        String input = Console.readLine();
        validator.validate(input);
        PlayerNumber player = new PlayerNumber(input);
        ComparisonResult result = new ComparisonResult(player, computer);

        while (!result.isGameEnd()) {
            System.out.print(result.getMessage() + "\n" + NEED_GAME_INPUT_MESSAGE);

            input = Console.readLine();
            validator.validate(input);
            player = new PlayerNumber(input);
            result = new ComparisonResult(player, computer);
        }

        System.out.println(END_GAME_MESSAGE);
        return isGameContinue();
    }

    private int isGameContinue() {
        System.out.println(RESTART_CHECK_MESSAGE);
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput == CONTINUE_GAME_STATUS || userInput == END_GAME_STATUS) {
            return userInput;
        }

        throw new IllegalArgumentException();
    }
}