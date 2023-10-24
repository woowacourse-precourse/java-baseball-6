package baseball;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallCounter {
    public List<Integer> human = new ArrayList<>();
    public List<Integer> computer = new ArrayList<>();
    public Map<String, Integer> counter = new HashMap<>();



    public BallCounter() throws IOException {

    }

    //extractRandom 끝난 값을 전달받아야 한다.
    //split 완료 된 human 을 전달받아야 한다.
    //스트라이크, 볼 갯수 판별
    public Map<String, Integer> ballCounting(List<Integer> computer, List<Integer> human) {
        counter.put("strike", 0);
        counter.put("ball", 0);

        for (int i = 0; i < 3; i++) {
            if (human.contains(computer.get(i))) {
                counter.put("strike", validate(i));
            }
        }
        return counter;
    }

    private int validate(int i) {
        if (computer.get(i) == human.get(i)) {
            return counter.get("strike") + 1;
        }
        counter.put("ball", counter.get("ball") + 1);
        return counter.get("strike");
    }
}