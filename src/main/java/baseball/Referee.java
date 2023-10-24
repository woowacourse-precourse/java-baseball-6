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

    public static int calculateBall(String userInput, String targetNumber) {
        int balls = 0;
        for (int i = 0; i < userInput.length(); i++) {
            char userChar = userInput.charAt(i);
            for (int j = 0; j < targetNumber.length(); j++) {
                if (userChar == targetNumber.charAt(j) && i != j) {
                    balls++;
                }
            }
        }
        return balls;
    }
}
