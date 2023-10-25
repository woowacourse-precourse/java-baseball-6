package baseball.domain;

import static baseball.global.enums.GameResult.BALL;
import static baseball.global.enums.GameResult.NOTHING;
import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GameResult.STRIKE;

import java.util.List;

/**
 * 사용자 입력값과 컴퓨터가 생성한 수를 비교하며 숫자 야구게임을 진행하는 클래스 숫자 비교 기능 포함 비교 결과는 각각 ball과 strike 변수에 저장된다(카운트 1씩)
 */
public class Round {

    private int strike;
    private int ball;

    public Round() {
        strike = 0;
        ball = 0;
    }

    /**
     * 플레이어의 수와 컴퓨터가 생성한 수를 비교하는 메서드
     *
     * @param computerNum
     * @param playerNum
     */
    public void compare(List<Integer> computerNum, List<Integer> playerNum) {

        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i).equals(playerNum.get(i))) {
                updateStrike();
            } else if (computerNum.contains(playerNum.get(i))) {
                updateBall();
            }
        }
    }

    /**
     * 비교한 결과에 따라 출력값을 반환하는 메서드
     *
     * @return
     */
    public String getResult() {
        if (ball == 0 && strike == 0) {
            return NOTHING.name;
        }

        if (ball == 0) {
            return String.format(STRIKE.name, strike);
        }
        if (strike == 0) {
            return String.format(BALL.name, ball);
        }
        if (strike == 3) {
            return PERFECT.name;
        }

        return String.format(BALL.name, ball) + " " + String.format(STRIKE.name, strike);
    }

    /**
     * 두 수의 비교에서 같은 위치에 같은 수가 존재하는 경우, strike 1 증가
     */
    private void updateStrike() {
        strike++;
    }

    /**
     * 두 수의 비교에서 다른 위치에 같은 수가 존재하는 경우, ball 1 증가
     */
    private void updateBall() {
        ball++;
    }
}
