package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String USER_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public String inputUserGameNumber() {
        System.out.println(USER_GAME_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
