package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static Computer instance = new Computer();
    private List<Integer> answer = new ArrayList<>();

    private Computer(){
    }

    public List<Integer> makeNewAnswer(){
        return answer = Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public static Computer getInstance() {
        return instance;
    }
}
