package baseball.view;

import baseball.util.GameInputValidator;
import baseball.util.ReStartInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUM_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String RE_START_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {

    }

    public static InputView getInstance() {
        return new InputView();
    }

    // 메서드 네임 리팩토링 필요
    public void showGameStartMent() {
        System.out.println(GAME_START_MESSAGE);
    }

    public int readNum() throws IllegalArgumentException {
        System.out.print(INPUT_NUM_MESSAGE);
        String gameInputNum = Console.readLine();
        new GameInputValidator().validate(gameInputNum);
        return Integer.parseInt(gameInputNum);
    }

    public int readNumOfReGame() throws IllegalArgumentException {
        System.out.println(RE_START_MESSAGE);
        String reStartInputNum = Console.readLine();
        new ReStartInputValidator().validate(reStartInputNum);
        return Integer.parseInt(reStartInputNum);
    }


}
