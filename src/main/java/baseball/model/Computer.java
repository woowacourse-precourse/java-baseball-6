package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBERS_SIZE = 3;
    private Numbers computerNumber;

    public Computer() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBERS_SIZE) {
            addRandomNumber(numbers);
        }

        computerNumber = new Numbers(numbers);
    }

    private void addRandomNumber(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public GameResult compareNumbers(User user) {
        Numbers userNumber = user.getUserNumber();

        return computerNumber.compareNumbers(userNumber);
    }
}
