package baseball;

public class Computer {
    private Answer answer;

    public Computer(Answer answer) {
        this.answer = answer;
    }

    public void printResult(Guess guess) {
        int strikes = getStrikesCount(guess);
        int balls = getBallsCount(guess);

        String comment = (strikes == 0 && balls == 0) ? "낫싱" : ((balls > 0 ? balls + "볼 " : "") +
                (strikes > 0 ? strikes + "스트라이크" : ""));
        System.out.println(comment);
    }

    private int getBallsCount(Guess guess) {
        int balls = 0;
        for (int i = 0; i < guess.getGuess().length(); i++) {
            char inputChar = guess.getGuess().charAt(i);
            if (this.answer.getAnswer().contains("" + inputChar)) {
                balls++;
            }
        }
        return balls - getStrikesCount(guess);
    }

    public int getStrikesCount(Guess guess) {
        int strikes = 0;
        for (int i = 0; i < guess.getGuess().length(); i++) {
            char inputChar = guess.getGuess().charAt(i);
            char answerChar = this.answer.getAnswer().charAt(i);
            if (inputChar == answerChar) {
                strikes++;
            }
        }
        return strikes;
    }
}
