package view;

import static model.BaseballData.*;
import static model.BaseballData.STRIKE;

public class OutputView {
    static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_BALL = "숫자를 입력해주세요 : ";
    static final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RETRY_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /**
     * 야구 게임 시작
     */
    public void gameStart() {
        System.out.println(START_GAME);
    }

    /**
     * 야구 숫자 입력받기
     */
    public void gameNumer() {
        System.out.print(INPUT_BALL);
    }

    /**
     * 야구 게임 결과 출력
     */
    public static void gameResult(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        // 볼 스트라이크
        if (strike == SUCCESS) {
            result.append(strike).append(STRIKE);
        } else if (strike == FAIL && ball == FAIL) {
            result.append(NOTHING);
        } else {
            if (ball > FAIL)
                result.append(ball).append(BALL).append(" ");
            if (strike > FAIL)
                result.append(strike).append(STRIKE);
        }
        System.out.println(result);
    }

    /**
     * 야구 게임 종료
     */
    public void gameFinish() {
        System.out.println(GAME_FINISH);
    }

    /**
     * 야구 게임 재시작 여부
     */
    public void restartGame() {
        System.out.print(RETRY_GAME);
    }
}
