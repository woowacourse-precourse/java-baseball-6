package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Computer;
import baseball.view.NumberBaseballView;

public class NumberBaseball {
    private final NumberBaseballView numberBaseballView;
    private final Computer computer;

    public NumberBaseball() {
        numberBaseballView = new NumberBaseballView();
        computer = new Computer();
    }

    public void startNumberBaseball() {
        computer.createRandomNumber();
        numberBaseballView.startNumberBaseball();

        //반복 필요
        String userNumber = numberBaseballView.getUserInput();
        BaseballNumber baseballNumber = new BaseballNumber(userNumber);
        String result = computer.getResult(userNumber);
        numberBaseballView.showBaseballResult(result);
    }


}
