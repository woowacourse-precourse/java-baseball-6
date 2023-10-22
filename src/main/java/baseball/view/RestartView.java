package baseball.view;

import baseball.domain.Restart;

public class RestartView {

    public static final String RESTART_CHOICE_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            Restart.RESTART_GAME.getValue(),
            Restart.EXIT_GAME.getValue()
    );

    public static void displayRestartChoiceMessage() {
        System.out.println(RESTART_CHOICE_MESSAGE);
    }
}
