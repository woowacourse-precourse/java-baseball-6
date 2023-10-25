package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int MAX_OF_RANDOM_NUMBER_SIZE = 3;
    private static final int MAX_OF_RANDOM_NUMBER = 9;
    public static final int MIN_OF_RANDOM_NUMBER = 1;

    public String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_OF_RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_OF_RANDOM_NUMBER, MAX_OF_RANDOM_NUMBER);
            checkForDuplicates(computer, randomNumber);
        }
        return convertListToString(computer);
    }

    private void checkForDuplicates(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private String convertListToString(List<Integer> randomNumber) {
        StringBuilder converted = new StringBuilder();
        for (int i = 0; i < MAX_OF_RANDOM_NUMBER_SIZE; i++) {
            converted.append(randomNumber.get(i));
        }
        return converted.toString();
    }
}