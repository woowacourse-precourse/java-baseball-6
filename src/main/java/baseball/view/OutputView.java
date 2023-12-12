package baseball.view;

import baseball.Constants;
import baseball.domain.Score;

public class OutputView {


    public void startGame() {
        final String START = "숫자 야구 게임을 시작합니다.";
        System.out.println(START);
    }

    public void enterNumbers() {
        final String ENTER_NUMBERS = "숫자를 입력해주세요 : ";
        System.out.print(ENTER_NUMBERS);
    }

    public void GameResult(Score score) {
        final String BALL = "볼 ";
        final String STRIKE = "스트라이크";
        final String NOTHING = "낫싱";
        String result = "";
        int ball = score.getBall();
        int strike = score.getStrike();

        if (ball != 0) {
            result += ball + BALL;
        }
        if (strike != 0) {
            result += strike + STRIKE;
        }
        if (result.isEmpty()) {
            result = NOTHING;
        }
        System.out.println(result.trim());
    }

    public void wonGame() {
        final String WON = Constants.NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(WON);
        System.out.println(RESTART);
    }

    public void endGame() {
        final String END = "게임 종료";
        System.out.println(END);
    }
}
