package baseball.model;

import baseball.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    private final Integer RESTART_GAME = 1;
    private final Integer END_GAME = 2;

    public Number readNumberInput() {
        int number = Integer.parseInt(Console.readLine());
        return new Number(number);
    }

    public Integer readFinishInput() {
        int number = Integer.parseInt(Console.readLine());

        return switch (number) {
            case 1 -> RESTART_GAME;
            case 2 -> END_GAME;
            default -> throw new IllegalArgumentException(ErrorMessage.FINISH_INPUT_IS_WRONG.getMessage());
        };
    }

}
