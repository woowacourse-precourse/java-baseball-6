package baseball.controller;

import static baseball.model.Constant.FINISH_END_INT;
import static baseball.model.Constant.RESTART_END_INT;

import baseball.model.BaseballNumber;
import baseball.model.Computer;
import baseball.view.NumberBaseballView;

public class NumberBaseball {
    private final NumberBaseballView numberBaseballView;
    private final Computer computer;
    private boolean isEnd = false;

    public NumberBaseball() {
        numberBaseballView = new NumberBaseballView();
        computer = new Computer();
    }

    public void startNumberBaseball() {

        numberBaseballView.startNumberBaseball();
        computer.createRandomNumber();
        while (!isEnd) {

            String userNumber = numberBaseballView.getUserInput();

            BaseballNumber baseballNumber = new BaseballNumber(userNumber);
            String result = computer.getResult(userNumber);
            numberBaseballView.showBaseballResult(result);

            boolean isCorrect = computer.getIsCorrect(userNumber);
            if (isCorrect) {
                endGame();
            }
        }

    }

    private void endGame() {
        int endInput = numberBaseballView.endNumberBaseball();
        if (endInput == RESTART_END_INT) {
            computer.createRandomNumber();
        }
        if (endInput == FINISH_END_INT) {
            this.isEnd = true;
        }
    }


}
