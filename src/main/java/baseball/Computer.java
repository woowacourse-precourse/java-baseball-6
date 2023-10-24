package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static Computer instance = new Computer();
    private List<Integer> computer = new ArrayList<>();

    private Computer(){
    }

    public List<Integer> makeNewAnswer(){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Computer getInstance() {
        return instance;
    }
}
