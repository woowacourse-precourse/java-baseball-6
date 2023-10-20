package baseball.model;

import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> computer = new ArrayList<>();
    public Computer(ArrayList<Integer> computer) {
        this.computer = computer;
    }

    public ArrayList<Integer> getComputer() {
        return this.computer;
    }
}
