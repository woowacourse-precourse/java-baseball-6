package baseball.model;

import baseball.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public Number readNumberInput() {

        int number = Integer.parseInt(Console.readLine());
        return new Number(number);
    }

    public FinishInput readFinishInput() {
        int number = Integer.parseInt(Console.readLine());

        return switch (number) {
            case 1 -> FinishInput.RESTART_GAME;
            case 2 -> FinishInput.END_GAME;
            default -> throw new IllegalArgumentException(ErrorMessage.FINISH_INPUT_IS_WRONG.getMessage());
        };
    }

}
