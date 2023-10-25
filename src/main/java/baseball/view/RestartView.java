package baseball.view;

import baseball.domain.RestartOption;

public class RestartView {

    public static final String RESTART_CHOICE_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            RestartOption.RESTART_GAME.getValue(),
            RestartOption.EXIT_GAME.getValue()
    );

    public static void displayRestartChoiceMessage() {
        System.out.println(RESTART_CHOICE_MESSAGE);
    }
}
