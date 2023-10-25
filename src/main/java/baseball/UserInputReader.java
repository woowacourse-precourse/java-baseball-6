package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputReader {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_RESET_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public String enterGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        isValidUserNumberInput(inputNumber);
        return inputNumber;
    }

    public String enterAnswerRestartGame() {
        System.out.print(ASK_RESET_GAME_MESSAGE);
        String inputAnswer = Console.readLine();
        isValidUserAnswerInput(inputAnswer);
        return inputAnswer;
    }

    private void isValidUserNumberInput(String input) {
        InputValidator.isValidUserNumberInput(input);
    }
    private void isValidUserAnswerInput(String input) {
        InputValidator.isValidUserAnswerInput(input);
    }

}
