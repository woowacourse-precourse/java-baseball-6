package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.BALL_MAX;
import static baseball.util.Constants.BALL_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public record Computer(List<Integer> computerNumber) {

    public Computer() {
        this(createRandomNumbers());
    }

    public static Computer createByNumber() {
        return new Computer();
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        return generateDistinctRandomNumbers(randomNumbers);
    }

    private static List<Integer> generateDistinctRandomNumbers(List<Integer> numbers) {
        if (numbers.size() >= BALL_LENGTH) {
            return numbers;
        }

        int randomNum = createRandomNumber();
        if (!numbers.contains(randomNum)) {
            numbers.add(randomNum);
        }

        return generateDistinctRandomNumbers(numbers);
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(BALL_MIN, BALL_MAX);
    }

    public int getNumberByPosition(int position) {
        return computerNumber.get(position);
    }

    public boolean hasCommonNumber(int playerNumber) {
        return computerNumber.contains(playerNumber);
    }
}