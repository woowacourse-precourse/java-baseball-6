package baseball.generator;

import baseball.constants.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public String generateRandomBaseballNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.START_NUMBER, GameConstants.END_NUMBER);
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
