package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public String generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return convertListToString(numbers);
    }

    private String convertListToString(List<Integer> numbers) {
        StringBuilder numberString = new StringBuilder();
        for (int number : numbers) {
            numberString.append(number);
        }
        return numberString.toString();
    }
}
