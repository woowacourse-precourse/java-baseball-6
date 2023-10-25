package baseball.View;

import baseball.Exception.UserInputException;
import baseball.Util.StringToIntegerList;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InGameView {

    private final UserInputException userInputException = new UserInputException();
    private final StringToIntegerList stringToIntegerList = new StringToIntegerList();

    public InGameView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> userInput() {
        System.out.print("숫자를 입력해주세요. : ");
        String userInput = Console.readLine();
        userInputException.validateUserInput(userInput);

        return stringToIntegerList.stringToIntegerList(userInput);
    }
}
