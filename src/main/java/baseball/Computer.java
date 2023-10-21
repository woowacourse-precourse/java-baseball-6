package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String randomNumber;

    public Computer() {
        makeRandomNumber();
    }

    public void makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int pickNumber = pickRandomNumber();
            if (!numberList.contains(pickNumber)) {
                numberList.add(pickNumber);
            }
        }

        this.randomNumber = numberList.toString().replaceAll("[^1-9]", "");
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}