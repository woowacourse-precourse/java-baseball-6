package baseball.model;

import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> targetNum;

    public Computer(ArrayList<Integer> targetNum){
        this.targetNum = targetNum;
    }

    public ArrayList<Integer> getTargetNum() {
        return targetNum;
    }
}
