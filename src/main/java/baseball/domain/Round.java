package baseball.domain;

import static baseball.global.enums.GameResult.BALL;
import static baseball.global.enums.GameResult.NOTHING;
import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GameResult.STRIKE;

import java.util.List;

/**
 * 사용자 입력값과 컴퓨터가 생성한 수를 비교하며 숫자 야구게임을 진행하는 클래스 - 숫자 비교 기능 포함 *비교 결과는 각각 ball과 strike 변수에 저장된다(카운트 1씩)
 */
public class Round {

    private int strike;
    private int ball;

    public Round() {
        strike = 0;
        ball = 0;
    }

    public void compare(List<Integer> computerNum, List<Integer> playerNum) {

        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i).equals(playerNum.get(i))) {
                updateStrike();
            } else if (computerNum.contains(playerNum.get(i))) {
                updateBall();
            }
        }
    }

    public String getResult() {
        if (ball == 0 && strike == 0) {
            return NOTHING.name;
        }

        if (ball == 0) {
            return strike + STRIKE.name;
        }
        if (strike == 0) {
            return ball + BALL.name;
        }
        if (strike == 3) {
            return PERFECT.name;
        }

        return ball + BALL.name + " " + strike + STRIKE.name;
    }

    private void updateStrike() {
        strike++;
    }

    private void updateBall() {
        ball++;
    }
}
