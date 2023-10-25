package baseball.numsdata;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberManage {
    private List<Integer> computer;

    public ComputerNumberManage() {
        makeRandomNums();
    }
    public void makeRandomNums() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers(){
        return computer;
    }
}
