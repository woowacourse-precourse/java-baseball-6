package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getUserInput() {
        System.out.print(USER_INPUT_MESSAGE);
        return readLine();
    }
}
