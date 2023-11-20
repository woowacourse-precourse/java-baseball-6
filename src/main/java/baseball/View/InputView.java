package baseball.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String STARTING_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String ENTER_USER = "숫자를 입력해주세요 : ";
    public void startGame() {
        System.out.println(STARTING_GAME);
    }

    public String enterNumbers() {
        System.out.println(ENTER_USER);
        return readLine();
    }
}
