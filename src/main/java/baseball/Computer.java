package baseball;

public class Computer {
    private Answer correctAnswer;

    public Computer() {
        this.correctAnswer = new Answer();
    }

    public void updateAnswer() {
        this.correctAnswer = new Answer();
    }

    public Result checkAnswer(Answer input) {
        int strike = countStrike(input);
        int ball = countSameNum(input) - strike;

        return new Result(strike, ball);
    }

    private int countStrike(Answer input) {
        int strikeCount = 0;
        String answerStr = this.correctAnswer.getValue();
        String inputStr = input.getValue();

        for (int i = 0; i < answerStr.length(); i++) {
            if (answerStr.charAt(i) == inputStr.charAt(i)) strikeCount++;
        }

        return strikeCount;
    }

    private int countSameNum(Answer input) {
        int sameNumCount = 0;
        char[] answerDigits = this.correctAnswer.getValue().toCharArray();

        for (char digit : answerDigits) {
            if (input.getValue().contains(String.valueOf(digit))) sameNumCount++;
        }

        return sameNumCount;
    }
}
