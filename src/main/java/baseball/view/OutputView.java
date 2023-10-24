package baseball.view;

import baseball.domain.RoundResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void print(RoundResult roundResult) {
        System.out.println(roundResult.toString());

        if (roundResult.isGameEnd()) {
            System.out.println(GAME_END_MESSAGE);
        }
    }
}
