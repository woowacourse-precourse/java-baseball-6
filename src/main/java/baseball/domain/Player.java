package baseball.domain;

import baseball.util.InputUtil;

import java.util.List;

public class Player {

    private final InputUtil inputUtil = new InputUtil();

    public List<Integer> inputNumber() {
        return inputUtil.input();
    }

    public int inputReplay() {
        return inputUtil.inputReplay();
    }

}
