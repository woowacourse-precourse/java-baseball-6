package baseball.view;

import baseball.domain.Score;

public class OutputView {

    private static final String START_BASEBALL_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_BASEBALL_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startGame() {
        System.out.println(START_BASEBALL_GAME_MESSAGE);
    }

    public static void endGame() {
        System.out.println(END_BASEBALL_GAME_MESSAGE);
    }

    public static boolean matchResult(Score score) {
        System.out.println(score.toString());
        return score.isStrikeOut();
    }
}
