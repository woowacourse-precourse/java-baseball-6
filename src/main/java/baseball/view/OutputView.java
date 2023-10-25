package baseball.view;

import baseball.vo.Score;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼\n";
    private static final String STRIKE = "%d스트라이크\n";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private static final int ZERO_SCORE = 0;

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printUserInputMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }

    public void printScore(Score score) {
        if (score.getBall() == ZERO_SCORE && score.getStrike() == ZERO_SCORE) {
            System.out.println(NOTHING);
            return;
        }
        if (score.getStrike() == ZERO_SCORE) {
            System.out.printf(BALL, score.getBall());
            return;
        }
        if (score.getBall() == ZERO_SCORE) {
            System.out.printf(STRIKE, score.getStrike());
            return;
        }

        System.out.printf(BALL_AND_STRIKE, score.getBall(), score.getStrike());
    }

    public void printGameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
