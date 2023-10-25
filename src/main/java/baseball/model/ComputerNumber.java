package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private static final int MAX_LENGTH = 3;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;

    public List<Integer> computerNumber;

    public ComputerNumber() {
        this.computerNumber = generateNumbers();
    }

    public boolean contains(int number) {
        return computerNumber.contains(number);
    }

    public int indexOf(int number) {
        return computerNumber.indexOf(number);
    }

    public int get(int number) {
        return computerNumber.get(number);
    }

    public static List<Integer> generateNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }
}
