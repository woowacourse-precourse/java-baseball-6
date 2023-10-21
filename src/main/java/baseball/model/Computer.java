package baseball.model;

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
