package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallNumber {
    private List<Integer> baseballNumber;
    private Map<Integer, Integer> baseballNumberCounterMap = new HashMap<>();

    public BaseBallNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
        initBaseballNumberCounterMap();

    }

    public BaseBallNumber(String baseballNumber) {
        this.baseballNumber = stringToList(baseballNumber);
        initBaseballNumberCounterMap();
    }

    private void initBaseballNumberCounterMap() {
        for (Integer c : baseballNumber) {
            baseballNumberCounterMap.put(c, baseballNumberCounterMap.getOrDefault(c, 0) + 1);
        }
    }

    public int getNumberSize() {
        return this.baseballNumber.size();
    }

    public List<Integer> getBaseballNumber() {
        return this.baseballNumber;
    }

    public Map<Integer, Integer> getBaseballNumberCounterMap() {
        return this.baseballNumberCounterMap;
    }

    private List<Integer> stringToList(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = Character.getNumericValue(c);
            result.add(digit);
        }

        return result;
    }

    public static BaseBallNumber generateRandomNumber() {
        List<Integer> cpuNumber = new ArrayList<>();
        while (cpuNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!cpuNumber.contains(randomNumber)) {
                cpuNumber.add(randomNumber);
            }
        }
        return new BaseBallNumber(cpuNumber);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int number : baseballNumber) {
            result.append(number);
        }

        return result.toString();
    }
}