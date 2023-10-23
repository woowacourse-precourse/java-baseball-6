package baseball.view;

import static baseball.model.Result.BALL;
import static baseball.model.Result.NOTHING;
import static baseball.model.Result.STRIKE;

import baseball.model.Judgement;

public class Output {

    private static final int ZERO = 0;
    private static final String BLANK = " ";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void showStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void showInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void showGameResult(Judgement judgement) {
        System.out.println(assembleResult(judgement));
    }

    private String assembleResult(Judgement judgement) {
        StringBuilder result = new StringBuilder();
        appendBall(judgement, result);
        appendStrike(judgement, result);

        if (result.length() == ZERO) {
            return NOTHING.toString();
        }
        return result.toString();
    }

    private void appendBall(Judgement judgement, StringBuilder result) {
        if (judgement.hasBall()) {
            result.append(judgement.getBall()).append(BALL);
        }
    }

    private void appendStrike(Judgement judgement, StringBuilder result) {
        if (judgement.hasStrike()) {
            if (ZERO < result.length()) {
                result.append(BLANK);
            }
            result.append(judgement.getStrike()).append(STRIKE);
        }
    }

    public void showGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public void showGameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }
}
