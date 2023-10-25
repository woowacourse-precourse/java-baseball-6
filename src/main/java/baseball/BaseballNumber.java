package baseball;

import static baseball.BaseballConstants.BASEBALL_NUMBER_SIZE;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {
    private static final int INIT_NUMBER = 0;

    private String  computerNumber;
    private Set<Character> seenComputerNumber;
    private RandomNumberGenerator randomNumberGenerator;


    public static BaseballNumber getInstance(RandomNumberGenerator randomNumberGenerator) {
        return new BaseballNumber(randomNumberGenerator);
    }

    public String compare(String inputNumber) {
        Baseball baseball = Baseball.getInstance();
        for (int i = INIT_NUMBER; i < inputNumber.length(); i++) {
            if (!seenComputerNumber.contains(inputNumber.charAt(i))) continue;
            if (computerNumber.charAt(i) == inputNumber.charAt(i)) {
                baseball.incrementStrikeCount();
                continue;
            }
            baseball.incrementBallCount();
        }
        return baseball.toString();
    }

    private BaseballNumber(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        computerNumber = randomNumberGenerator.generateNonRepeatingRandomDigitSequence(
            BASEBALL_NUMBER_SIZE);
        seenComputerNumber = new HashSet<>();
        putComputerNumberInSeenValues();
    }
    private void putComputerNumberInSeenValues() {
        for (int i = INIT_NUMBER; i < computerNumber.length(); i++) {
            seenComputerNumber.add(computerNumber.charAt(i));
        }
    }
}
