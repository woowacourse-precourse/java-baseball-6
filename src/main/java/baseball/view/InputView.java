package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String getPlayerInput() {
        System.out.print(PLAYER_INPUT_MESSAGE);
        return Console.readLine();
    }

}
