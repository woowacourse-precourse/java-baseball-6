package baseball.controller;

import baseball.domain.BallAndStrike;
import baseball.domain.BaseBallNumber;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;


public class BaseballController {
    // TODO: 유저 입력 검사, 출력
    private int numSize;

    public BaseballController(int numSize) {
        this.numSize = numSize;
    }

    public void userGameStart() {
        BaseballView.printGameStart();
    }

    public BaseBallNumber requestUserBaseBallNumberInput() {
        BaseballView.requestUserInput();

        BaseBallNumber userNumber = new BaseBallNumber(Console.readLine());
        validateCorrectInputNumber(userNumber);

        return userNumber;
    }

    public String requestUserGameExit() {
        BaseballView.requestGameExit();
        return Console.readLine();
    }

    private void validateCorrectInputNumber(BaseBallNumber baseBallNumber) throws IllegalArgumentException {
        HashSet<Integer> baseballNumberSet = new HashSet<>(baseBallNumber.getBaseballNumber());

        if (baseballNumberSet.size() != this.numSize) {
            throw new IllegalArgumentException("서로 다른 3자리를 입력해야합니다.");
        } else if (baseBallNumber.getNumberSize() != this.numSize) {
            throw new IllegalArgumentException("숫자의 길이는 " + this.numSize + "이어야 합니다.");
        } else if (baseballNumberSet.contains(0)) {
            throw new IllegalArgumentException("0이 포함되어선 안됩니다.");
        }
    }

    public void userGuessBallAndStrike(BallAndStrike ballAndStrike) {
        BaseballView.printGuessValue(ballAndStrike);
    }

    public void userGameEnd() {
        BaseballView.printGameEnd();
    }
}
