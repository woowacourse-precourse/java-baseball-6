package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private List<Integer> randomValue = new ArrayList<>(3);
    private List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

    public void makeRandom() {
        randomValue.clear();
        while (randomValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValue.contains(randomNumber)) {
                randomValue.add(randomNumber);
            }
        }
    }

    public List<Integer> getResult(List<Integer> input) {
        checkBall(input);
        checkStrike(input);
        return result;
    }

    private void checkBall(List<Integer> input) {
        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).equals(randomValue.get(i)) && randomValue.contains(input.get(i))) {
                count++;
            }
        }

        result.set(0, count);
    }

    private void checkStrike(List<Integer> input) {
        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(randomValue.get(i))) {
                count++;
            }
        }

        result.set(1, count);
    }

}
