package baseball.view;

import baseball.model.Rule;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final String ASK_RESET_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";


    public String enterPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String enterRestartGame() {
        System.out.print(ASK_RESET_GAME_MESSAGE);
        String inputValue = Console.readLine();

        validateRestartNumber(inputValue);

        return inputValue;
    }

    private void validateRestartNumber(String stringNumber) {
        if (!stringNumber.equals(Rule.RESTART_NUMBER) && !stringNumber.equals(Rule.EXIT_NUMBER)) {
            throw new IllegalArgumentException("재시작을 원하신다면 1, 종료를 원하신다면 2를 입력하세요.");
        }
    }
}