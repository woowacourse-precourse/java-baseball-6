package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    private final List<Integer> computerNumber;
    private static final int MAKE_NUMBER_SIZE_MIN = 3;
    private static final int RANDOM_NUMBER_MIN_RAGE = 1;
    private static final int RANDOM_NUMBER_MAX_RAGE = 9;

    public Baseball() {
        computerNumber = generateComputerNumber();
    }

    public List<Integer> generateComputerNumber() {
        List<Integer> arrayRandomNumber = new ArrayList<>();
        while (arrayRandomNumber.size() < MAKE_NUMBER_SIZE_MIN) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RAGE, RANDOM_NUMBER_MAX_RAGE);
            if (!arrayRandomNumber.contains(randomNumber)) {
                arrayRandomNumber.add(randomNumber);
            }
        }
        return arrayRandomNumber;
    }

    public GameResult checkToStrikeAndBall(List<Integer> insertUserNumber) {
        int strikeCount = checkStrike(insertUserNumber);
        int ballCount = checkBall(insertUserNumber);

        return new GameResult(strikeCount, ballCount);
    }

    private int checkStrike(List<Integer> insertUserNumber) {
        int strikeCount = 0;
        for (int i = 0; i < insertUserNumber.size(); i++) {
            int currentComputerNumber = computerNumber.get(i);
            int currentUserNumber = insertUserNumber.get(i);
            if (Objects.equals(currentComputerNumber, currentUserNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int checkBall(List<Integer> insertUserNumber) {
        int ballCount = 0;
        for (int currentUserNumber : insertUserNumber) {
            if (computerNumber.contains(currentUserNumber)) {
                ballCount++;
            }
        }
        return ballCount - checkStrike(insertUserNumber);
    }

}
