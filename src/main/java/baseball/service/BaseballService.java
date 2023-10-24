package baseball.service;

import baseball.domain.BaseBallNumber;

public class BaseballService {
    // TODO: 야구게임 로직
    private BaseBallNumber ansBaseBallNumber;

    public BaseballService(BaseBallNumber ansBaseBallNumber) {
        this.ansBaseBallNumber = ansBaseBallNumber;
    }

    public Integer[] checkBallAndStrike(BaseBallNumber inputNumber) {
        Integer[] ballsAndStrikes = ansBaseBallNumber.calcBallsAndStrikes(inputNumber);

        return ballsAndStrikes;
    }
}
