package baseball;

public class Computer {
    private final Answer answer;

    public Computer(Answer answer) {
        this.answer = answer;
    }

    public void printResult(String guess) {
        int strikes = getStrikesCount(guess);
        int balls = getBallsCount(guess);

        String comment = (strikes == 0 && balls == 0) ? "낫싱" : ((balls > 0 ? balls + "볼 " : "") +
                (strikes > 0 ? strikes + "스트라이크" : ""));
        System.out.println(comment);
    }

    private int getBallsCount(String guess) {
        int balls = 0;
        for (int i = 0; i < guess.length(); i++) {
            char inputChar = guess.charAt(i);
            if (answer.getAnswer().contains("" + inputChar)) {
                balls++;
            }
        }
        return balls - getStrikesCount(guess);
    }

    public int getStrikesCount(String guess) {
        int strikes = 0;
        for (int i = 0; i < guess.length(); i++) {
            char inputChar = guess.charAt(i);
            char answerChar = answer.getAnswer().charAt(i);
            if (inputChar == answerChar) {
                strikes++;
            }
        }
        return strikes;
    }
}
