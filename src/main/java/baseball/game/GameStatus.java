package baseball.game;

import static baseball.game.Numbers.isContainNumWithDiffPos;
import static baseball.game.Numbers.isContainNumWithSamePos;

public class GameStatus {

    private int strike;
    private int ball;

    public GameStatus() {
        clearGameStatus();
    }

    public void clearGameStatus() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isGameOver() {
        return this.strike == 3;
    }

    public void calcScore(NumbersDto oriDto, NumbersDto compDto) {
        for (int i = 0; i < 3; i++) {
            ball += isContainNumWithDiffPos(oriDto, compDto, i);
            strike += isContainNumWithSamePos(oriDto, compDto, i);
        }
    }

    public String gameResultString() {
        if (strike == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
