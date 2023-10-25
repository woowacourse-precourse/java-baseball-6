package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    // 게임 시작 메시지를 출력하고, 입력을 받는 함수
    public static String getUserInput() {
        System.out.print(USER_INPUT_MESSAGE);
        return readLine();
    }
}
