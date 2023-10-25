package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int GAME_NUMBER_LENGTH = 3;
    private List<Integer> numbers;

    public Computer() {}

    public List<Integer> getNumbers() {
        if(numbers.isEmpty()) {
            return null;
        }

        return numbers;
    }

    public void setRandomNumbers() {
        Set<Integer> computerNumber = new HashSet<>();

        while(computerNumber.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            computerNumber.add(randomNumber);
        }

        this.numbers = computerNumber.stream().toList();
    }
}
