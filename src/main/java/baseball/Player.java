package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> inputNumbers;

    public Player(String inputNumber) {
        List<Integer> inputNumbers = parsingNumber(inputNumber);
        this.inputNumbers = inputNumbers;
    }

    private List<Integer> parsingNumber(String inputNumber) {
        List<Integer> parsingNumbers = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char charDigit = inputNumber.charAt(i);
            int intDigit = Character.getNumericValue(charDigit);
            parsingNumbers.add(intDigit);
        }
        return parsingNumbers;
    }
}
