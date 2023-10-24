package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> targetNumbers = new ArrayList<>(3);

    public Computer() {
        while (targetNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> compareTargetNumbers(List<Integer> inputNumbers) {
        List<Integer> hintCounts = new ArrayList<>(Hints.values().length);

        setListZero(hintCounts);

        for (int i = 0; i < inputNumbers.size(); i++) {
            int hintType = calculateHint(inputNumbers.get(i), i);
            hintCounts.set(hintType, hintCounts.get(hintType) + 1);
        }

        return hintCounts;
    }

    private int calculateHint(int inputNumber, int inputNumberIndex) {
        for (int i = 0; i < targetNumbers.size(); i++) {
            if (targetNumbers.get(i) == inputNumber) {
                if (inputNumberIndex == i) {
                    return Hints.STRIKE.ordinal();
                }
                return Hints.BALL.ordinal();
            }
        }
        return Hints.NOTHING.ordinal();
    }

    private void setListZero(List<Integer> targetList) {
        for (int i = 0; i < targetList.size(); i++) {
            targetList.set(i,0);
        }
    }

}
