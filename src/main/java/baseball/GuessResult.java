package baseball;

public class GuessResult {
    private NumberSet input;
    private NumberSet answer;

    public GuessResult(NumberSet input, NumberSet answer) {
        this.input = input;
        this.answer = answer;
    }

    public int getStrikes() {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            Integer aDigit = this.input.getNumbers().get(i);
            Integer bDigit = this.answer.getNumbers().get(i);
            if (aDigit.equals(bDigit))
                strikes++;
        }
        return strikes;
    }

    public int getBalls() {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                Integer aDigit = this.input.getNumbers().get(i);
                Integer bDigit = this.answer.getNumbers().get(j);
                if (aDigit.equals(bDigit))
                    balls++;
            }
        }
        return balls;
    }
}
