package baseball;

public class Computer {
    private Answer correctAnswer;

    public Computer() {
        this.correctAnswer = Answer.createCorrectAnswer();
    }

    public void updateAnswer() {
        this.correctAnswer = Answer.createCorrectAnswer();
    }

    public Result checkAnswer(Answer input) {
        Integer strike = countStrike(input);
        Integer ball = countBall(input);

        return new Result(strike, ball);
    }

    private Integer countStrike(Answer input) {
        Integer strikeCount = 0;
        String answerStr = this.correctAnswer.getValue();
        String inputStr = input.getValue();

        for (int i = 0; i < answerStr.length(); i++) {
            if (answerStr.charAt(i) == inputStr.charAt(i)) strikeCount++;
        }

        return strikeCount;
    }

    private Integer countBall(Answer input) {
        return countSameNum(input) - countStrike(input);
    }


    private Integer countSameNum(Answer input) {
        Integer sameNumCount = 0;
        char[] answerDigits = this.correctAnswer.getValue().toCharArray();

        for (char digit : answerDigits) {
            if (input.getValue().contains(String.valueOf(digit))) sameNumCount++;
        }

        return sameNumCount;
    }
}
