package baseball.view;

import baseball.exception.ErrorMessage;
import baseball.model.FinishInput;
import baseball.model.Number;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String ASK_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Number readNumberInput() {
        System.out.println(ASK_INPUT_MESSAGE);
        int number = Integer.parseInt(Console.readLine());
        return new Number(number);
    }

    public FinishInput readFinishInput() {
        System.out.println(RESTART_OR_END_MESSAGE);
        int number = Integer.parseInt(Console.readLine());

        return switch (number) {
            case 1 -> FinishInput.RESTART_GAME;
            case 2 -> FinishInput.END_GAME;
            default -> throw new IllegalArgumentException(ErrorMessage.FINISH_INPUT_IS_WRONG.getMessage());
        };
    }

}
