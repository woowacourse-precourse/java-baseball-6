package baseball.view;

import static baseball.model.Result.BALL;
import static baseball.model.Result.NOTHING;
import static baseball.model.Result.STRIKE;

import baseball.model.Judgement;

public class Output {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void showStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void showInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void showGameResult(Judgement judgement) {
        int strike = judgement.getStrike();
        int ball = judgement.getBall();
        System.out.println(makeGameResult(strike, ball));
    }

    private String makeGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING.toString();
        }
        if (strike == 0) {
            return ball + BALL.toString();
        }
        if (ball == 0) {
            return strike + STRIKE.toString();
        }
        return ball + BALL.toString() + " " + strike + STRIKE.toString();
    }

    public void showGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
