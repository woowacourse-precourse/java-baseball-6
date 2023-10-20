package baseball.model;

public class Referee {

    public int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        int strikeNumbers = 0;
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (randomNumbers.charAt(i) == inputNumbers.charAt(i)) {
                strikeNumbers++;
            }
        }
        return strikeNumbers;
    }
}
