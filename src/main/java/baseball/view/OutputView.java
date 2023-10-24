package baseball.view;

import baseball.vo.Score;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printUserInputMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }

    public void printScore(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0){
            System.out.println("낫싱");
            return;
        }
        if (score.getStrike() == 0){
            System.out.printf("%d볼%n", score.getBall());
            return;
        }
        if (score.getBall() == 0){
            System.out.printf("%d스트라이크\n", score.getStrike());
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", score.getBall(), score.getStrike());
    }

    public void printGameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
