package baseball.domain;

import java.util.List;

public class GameResult {

    private int ball = 0;
    private int strike = 0;


    public GameResult(Computer computer, Player player) {
        //TODO 게임 결과 계산
    }

    public boolean isRight() {
        return strike == 3;
    }
}
