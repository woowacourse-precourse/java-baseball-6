package baseball.view;

import baseball.domain.Regame;

public class RestartView {

    public static final String RESTART_CHOICE_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            Regame.RESTART_GAME.getValue(),
            Regame.EXIT_GAME.getValue()
    );

    public static void displayRestartChoiceMessage() {
        System.out.println(RESTART_CHOICE_MESSAGE);
    }
}
