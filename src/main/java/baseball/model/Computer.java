package baseball.model;

import baseball.view.InputView;

import java.util.HashSet;
import java.util.LinkedList;

public class Computer {

    private LinkedList<Integer> computerNum;

    public Computer(LinkedList<Integer> computerNum) {
        this.computerNum = computerNum;
    }

    public LinkedList<Integer> getComputerNum() {
        return computerNum;
    }
}
