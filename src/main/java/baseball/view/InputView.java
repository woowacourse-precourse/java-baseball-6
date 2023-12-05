package baseball.view;

import baseball.utils.validator.PlayAgainInputValidator;
import baseball.utils.validator.UserNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static InputView instance = new InputView();
    private static final String ASK_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<Integer> readUserNumber() {
        System.out.print(ASK_USER_NUMBER_MESSAGE);
        String input = Console.readLine();
        UserNumberValidator.validateNumeric(input);
        return UserNumberValidator.convertToIntegerList(input);
    }

    public int readPlayAgainInput() {
        System.out.println(ASK_PLAY_AGAIN_MESSAGE);
        String input = Console.readLine();
        return PlayAgainInputValidator.safeParseInt(input);
    }
}
