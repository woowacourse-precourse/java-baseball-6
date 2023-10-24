package baseball;

import java.util.List;

public class Computer {

    private List<Integer> secretNumbers;
    private final SecretNumberPicker secretNumberPicker;

    public Computer() {
        this.secretNumberPicker = new SecretNumberPicker();
    }

    public void pickSecretNumbers() {
        this.secretNumbers = secretNumberPicker.pickSecretNumbers();
    }

    public GameResult countStrikesAndBalls(List<Integer> guessNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int idx = 0; idx < GameConstants.NUMBER_LENGTH; idx++) {
            if (secretNumbers.get(idx).equals(guessNumbers.get(idx))) {
                strikes++;
            } else {
                if (secretNumbers.contains(guessNumbers.get(idx))) {
                    balls++;
                }
            }
        }
        return new GameResult(strikes, balls);
    }

}
