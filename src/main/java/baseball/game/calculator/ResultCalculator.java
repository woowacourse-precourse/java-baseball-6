package baseball.game.calculator;

import baseball.constants.GameConstants;

public class ResultCalculator {

    public String calculateResult(String userInput, String computerNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userInput.length(); i++) {
            char userChar = userInput.charAt(i);
            if (userChar == computerNumber.charAt(i)) {
                strikes++;
            } else if (computerNumber.contains(String.valueOf(userChar))) {
                balls++;
            }
        }

        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 3) {
            return GameConstants.VICTORY_MESSAGE;
        } else if (strikes == 0 && balls == 0) {
            return GameConstants.GAME_NOTHING_STR;
        } else {
            return generateResultString(balls, strikes);
        }
    }

    private String generateResultString(int balls, int strikes) {
        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls).append(GameConstants.GAME_BALL_STR + " ");
        }
        if (strikes > 0) {
            result.append(strikes).append(GameConstants.GAME_STRIKE_STR);
        }

        return result.toString().trim();
    }
}
