package baseball.view;

import baseball.model.GameRestartString;
import baseball.model.StringNumbers;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자야구 게임을 위해 필요한 입력 값을 받을 때 사용하는 클래스입니다.
 */

public class InputView {

    /**
     * 유저에게 숫자야구 값 입력을 요구하고 입력받습니다.
     *
     * @return 숫자로만 이루어진 String을 포장한 객체
     */

    public static StringNumbers getStringNumbers() {
        OutputView.printEnterNumber();
        String input = Console.readLine();
        return new StringNumbers(input.trim());
    }

    /**
     * 유저에게 게임 재시작 여부 입력을 요구하고 입력습니다.
     *
     * @return 게임 재시작 여부에 사용될 수 있는 String을 포장한 객체
     */

    public static GameRestartString getGameRestartString() {
        OutputView.printAnswer();
        String input = Console.readLine();
        return new GameRestartString(input.trim());
    }
}
