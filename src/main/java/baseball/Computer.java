package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final String REGEX = "[^1-9]";
    private static final String SPLIT = "";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private String randomNumber;

    public Computer() {
        makeRandomNumber();
    }

    public void makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < RANDOM_NUMBER_LENGTH) {
            int pickNumber = pickRandomNumber();
            // 메소드 분리
            if (!numberList.contains(pickNumber)) {
                numberList.add(pickNumber);
            }
        }

        this.randomNumber = numberList.toString().replaceAll(REGEX, SPLIT);
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}