package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computer;

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }


    public Integer getComputer(int i) {
        return computer.get(i);
    }

}
