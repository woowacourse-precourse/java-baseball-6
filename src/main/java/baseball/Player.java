package baseball;

import baseball.util.InputUtil;

public class Player {

    private final InputUtil inputUtil = new InputUtil();

    public int inputNumber() {
        return inputUtil.inputNumber();
    }

    public int inputReplay() {
        return inputUtil.inputReplay();
    }

}
