package baseball;

import static baseball.utils.Constants.BALL_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ComputerNumber {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;

    private List<Character> computerNumbers;

    public void setComputerNumber() {
        this.computerNumbers = generateRandomNumbers();
    }

    public List<Character> getComputerNumbers() {
        return computerNumbers;
    }

    private List<Character> generateRandomNumbers() {
        LinkedHashSet<Character> tempNumbers = new LinkedHashSet<>();

        while (tempNumbers.size() < BALL_SIZE) {
            tempNumbers.add(Character.forDigit(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE), 10));
        }

        return new ArrayList<>(tempNumbers);
    }
}
