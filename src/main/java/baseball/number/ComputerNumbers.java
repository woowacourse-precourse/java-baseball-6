package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class ComputerNumbers {
    public final static int MIN_NUMBER_RANGE = 1;
    public final static int MAX_NUMBER_RANGE = 9;
    public final static int RANDOM_NUMBER_LENGTH = 3;
    private String computerNumber;

    public ComputerNumbers() {
        setComputerNumber();
    }

    public String getRandomNumber() {
        return computerNumber;
    }

    private void setComputerNumber() {
        LinkedHashSet<String> randomNumberSet = new LinkedHashSet<>();
        while (randomNumberSet.size() < RANDOM_NUMBER_LENGTH) {
            randomNumberSet.add(generateOneRandomNumber());
        }
        this.computerNumber = String.join("", randomNumberSet);
    }

    private String generateOneRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
    }
}
