package baseball.domain;


import java.util.List;

public class Answer {
    private final List<Integer> correctNumbers;

    public Answer(List<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public GuessResult checkAgainst(List<Integer> userInput) {
        List<Integer> guessedNumbers = userInput;
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < correctNumbers.size(); i++) {
            if (guessedNumbers.get(i).equals(correctNumbers.get(i))) {
                strikes++;
            }
            if (correctNumbers.contains(guessedNumbers.get(i))
                    && !guessedNumbers.get(i).equals(correctNumbers.get(i))) {
                balls++;
            }
        }
        return new GuessResult(strikes, balls);
    }
}
