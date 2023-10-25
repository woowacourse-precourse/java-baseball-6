package baseball.View;

import baseball.Exception.UserInputException;
import camp.nextstep.edu.missionutils.Console;

public class GameSetView {

    private final UserInputException userInputException = new UserInputException();

    public void printGameSetMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public int restartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        userInputException.validateRestartInput(userInput);

        return Integer.parseInt(userInput);
    }
}
