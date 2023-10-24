package baseball;

import java.util.ArrayList;
import java.util.List;

public class Nums {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> mine = new ArrayList<>();

    public List<Integer> getComputer() {
        return computer;
    }
    public List<Integer> getMine() {
        return mine;
    }

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }
    public void setMine(List<Integer> inputNumber) {
        this.mine = inputNumber;
    }
}