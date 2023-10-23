package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ball {

    private List<Integer> randomBall;
    private ArrayList<Map<String, Integer>> hintLog;
    private int size;

    public void createRandomBall(int size) {
        this.size = size;
    }

    private boolean isCorrectBall(String userBall) {
        Map<String, Integer> currentHint = getHint();
        hintLog.add(currentHint);

        if (currentHint.get("strike") >= 3) {

        }

        return true;
    }

    public Map<String, Integer> getCurrentHint() {
        Map<String, Integer> result = new HashMap<>();
        return result;
    }

    private Map<String, Integer> getHint() {
        Map<String, Integer> result = new HashMap<>();
        return result;
    }
}
