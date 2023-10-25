package baseball.controller;

import baseball.domain.BaseBallNumber;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;


public class BaseballController {
    // TODO: 유저 입력 검사, 출력
    private int numSize;

    public BaseballController(int numSize) {
        this.numSize = numSize;
    }

    public void userGameStart(){
        BaseballView.printGameStart();
    }

    public BaseBallNumber requestUserBaseBallNumberInput(){
        BaseBallNumber userNumber = new BaseBallNumber(Console.readLine());
        isCorrectRetryNumber(userNumber);

        BaseballView.requestUserInput();
        return userNumber;
    }

    private void isCorrectRetryNumber(BaseBallNumber baseBallNumber) throws IllegalArgumentException {
        if (baseBallNumber.getNumberSize() != this.numSize) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public void userGameEnd(){
        BaseballView.printGameEnd();
    }
}
