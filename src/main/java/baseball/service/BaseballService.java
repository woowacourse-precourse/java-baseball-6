package baseball.service;

import baseball.domain.BallAndStrike;
import baseball.domain.BaseBallNumber;

public class BaseballService {
    // 야구게임 로직 실행
    private BaseBallNumber ansBaseBallNumber;

    public BaseballService(BaseBallNumber ansBaseBallNumber) {
        this.ansBaseBallNumber = ansBaseBallNumber;
    }

    public BallAndStrike checkBallAndStrike(BaseBallNumber inputNumber) {
        return BallAndStrike.calcBallsAndStrikes(this.ansBaseBallNumber, inputNumber);
    }
}
