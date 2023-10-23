package baseball;

import static baseball.ConstValue.BASEBALL_MAX_LENGTH;
import static baseball.ConstValue.GAME_END_MENTION;
import static baseball.ConstValue.GAME_START_MENTION;
import static baseball.ConstValue.TRY_MENTION;
import static baseball.ConstValue.USER_INPUT_MENTION;

public class Narrator {

    public void startGame() {
        System.out.println(GAME_START_MENTION);
    }

    public void endGame() {
        System.out.println(GAME_END_MENTION);
    }

    public void inputUserValue() {
        System.out.print(USER_INPUT_MENTION);
    }

    public void retryGame() {
        System.out.println(TRY_MENTION);
    }

    public boolean isThreeStrike(Score score) {
        // 0스트라이크 0볼
        if (score.strike == 0 && score.ball == 0) {
            System.out.println("낫싱");
        }
        // 0스트라이크 1~3볼
        if (score.strike == 0 && score.ball != 0) {
            System.out.println(score.ball + "볼");
        }
        // 1~3스트라이크 0볼
        if (score.strike != 0 && score.ball == 0) {
            System.out.println(score.strike + "스트라이크");
            //3스트라이크면 true 반환
            if (score.strike == BASEBALL_MAX_LENGTH) {
                endGame();
                return true;
            }
        }
        // 1~2스트라이크 1~2볼
        if (score.strike != 0 && score.ball != 0) {
            System.out.println(score.ball + "볼 " + score.strike + "스트라이크");
        }
        return false;
    }

}
