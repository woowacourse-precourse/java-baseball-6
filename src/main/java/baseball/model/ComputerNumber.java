package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computer = new ArrayList<>();

    public ComputerNumber(){
        makeRandomNumber();
    }

    public List<Integer> getComputer(){
        return computer;
    }

    public void makeRandomNumber(){

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void clearRandomNumber(){
        computer.clear();
    }
}
