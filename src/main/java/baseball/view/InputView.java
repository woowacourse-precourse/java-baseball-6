package baseball.view;

import baseball.util.constants.BaseballGameConstants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String PROMPT_RESTART_OPTIONS = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요."
            .formatted(BaseballGameConstants.RESTART_OPTION_RESTART, BaseballGameConstants.RESTART_OPTION_EXIT);

    public String inputNumbers() {
        System.out.print(PROMPT_INPUT_NUMBERS);
        return Console.readLine();
    }

    public String inputRestartOption() {
        System.out.println(PROMPT_RESTART_OPTIONS);
        return Console.readLine();
    }
}
