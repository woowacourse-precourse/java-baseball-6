package baseball;

public class Referee {
    public static int calculateStrike(String userInput, String targetNumber) {
        int strikes = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == targetNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }
}
