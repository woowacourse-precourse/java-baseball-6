package baseball.view;

import static baseball.domain.GameConstants.NUMBER_LENGTH;

public class EndView {

    public static final String END_MESSAGE = String.format(
            "%d개의 숫자를 모두 맞히셨습니다! 게임 종료",
            NUMBER_LENGTH
    );

    public static void displayEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
