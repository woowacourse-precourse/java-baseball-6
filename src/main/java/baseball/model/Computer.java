package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.BALL_MAX;
import static baseball.util.Constants.BALL_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {

    private final List<Integer> computerNumber;

    private Computer() {
        this.computerNumber = createRandomNumbers();
    }

    public static Computer createByNumber() {

        return new Computer();
    }

    public List<Integer> createRandomNumbers() {
        return IntStream.generate(Computer::createRandomNumber)
                .boxed()
                .distinct()
                .limit(BALL_LENGTH)
                .collect(Collectors.toList());
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