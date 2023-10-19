package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateAnswer {
    private final int digits;

    public GenerateAnswer(int digits){
        this.digits = digits;
    }

    public List<Integer> genAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < digits) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
