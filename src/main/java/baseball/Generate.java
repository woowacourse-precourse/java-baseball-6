package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generate {
    public List<Integer> comNum(List<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
