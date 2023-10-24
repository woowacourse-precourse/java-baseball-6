package baseball.View;

import baseball.UserGameInput;
import baseball.UserNumberInput;
import java.util.List;

public class InputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void start() {
        System.out.println(START_MESSAGE);
    }

    public static List<Integer> UserInputView() {
        System.out.print(INPUT_MESSAGE);
        return UserNumberInput.input();
    }

    public static int choice() {
        System.out.println(CHOICE_MESSAGE);
        return UserGameInput.choice();
    }
}
