package baseball.controller;

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

        String userNumber = numberBaseballView.getUserInput();

    }


}
