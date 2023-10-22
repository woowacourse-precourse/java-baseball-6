package baseball.view;

import baseball.controller.RegameChoice;
import baseball.domain.GameConstants;

public class RestartChoiceView {

    public static final String RESTART_CHOICE_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            RegameChoice.RESTART_GAME.getValue(),
            RegameChoice.EXIT_GAME.getValue()
    );

    public static void displayRestartChoiceMessage() {
        System.out.println(RESTART_CHOICE_MESSAGE);
    }
}
