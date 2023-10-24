package baseball.app;

import baseball.global.enums.GameResult;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자 입력값과 컴퓨터가 생성한 수를 비교하며 숫자 야구게임을 진행하는 클래스 - 숫자 비교 기능 포함 *비교 결과는 각각 ball과 strike 변수에 저장된다(카운트 1씩)
 */
public class Baseball {

    private int strike;
    private int ball;
    private boolean[] checkNum;


    public Baseball() {
        strike = 0;
        ball = 0;
        checkNum = new boolean[9];
        Arrays.fill(checkNum, false);
    }

    public void compare(List<Integer> computerNum, List<Integer> playerNum) {
        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i).equals(playerNum.get(i))) {
                updateStrike();
            }
            checkNum[computerNum.get(i) - 1] = true;
            if (!checkNum[playerNum.get(i) - 1]) {
                checkNum[computerNum.get(i) - 1] = false;
            }
        }
        for (boolean b : checkNum) {
            if (b == true) {
                updateBall();
            }
        }
    }

    public String getResult() {
        if (ball == 0 && strike == 0) {
            return GameResult.NOTHING.name;
        }

        if (ball == 0) {
            return strike + GameResult.STRIKE.name;
        }
        if (strike == 0) {
            return ball + GameResult.BALL.name;
        }
        if (strike == 3) {
            return strike + GameResult.STRIKE.name + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        return ball + GameResult.BALL.name + " " + strike + GameResult.STRIKE.name;
    }

    private void updateStrike() {
        strike++;
    }

    private void updateBall() {
        ball++;
    }
}
