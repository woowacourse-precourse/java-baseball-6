package baseball.view;

import baseball.domain.Balls;
import baseball.domain.RoundResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRoundResult(Balls computer, Balls user) {
        System.out.println(RoundResult.of(computer, user));
    }
}
