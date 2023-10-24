package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallNumber{
    private List<Integer> baseballNumber;
    private Map<Integer, Integer> baseballNumberCounterMap = new HashMap<>();

    public BaseBallNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
        initBaseballNumberCounterMap();

    }
    private void initBaseballNumberCounterMap(){
        for (Integer c : baseballNumber) {
            baseballNumberCounterMap.put(c, baseballNumberCounterMap.getOrDefault(c, 0) + 1);
        }
    }

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }

    public Map<Integer, Integer> getBaseballNumberCounterMap() {
        return baseballNumberCounterMap;
    }

    public Integer[] calcBallsAndStrikes(BaseBallNumber inputNumber){
        Map<Integer, Integer> inputCounterMap = inputNumber.getBaseballNumberCounterMap();
        List<Integer> inputBaseballNumber = inputNumber.getBaseballNumber();

        int balls = getNumberCounterUnion(inputCounterMap);
        int strikes = getStrikes(inputBaseballNumber);

        balls -= strikes;

        return new Integer[]{balls, strikes};
    }

    private int getStrikes(List<Integer> inputBaseballNumber) {
        int strikes = 0;

        for (int i = 0; i < baseballNumber.size(); i++) {
            if (inputBaseballNumber.get(i).equals(baseballNumber.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    private int getNumberCounterUnion(Map<Integer, Integer> inputCounterMap) {
        int balls = 0;

        for (Integer key : baseballNumberCounterMap.keySet()) {
            if (inputCounterMap.containsKey(key)) {
                balls += Math.min(baseballNumberCounterMap.get(key), inputCounterMap.get(key));
            }
        }

        return balls;
    }


}