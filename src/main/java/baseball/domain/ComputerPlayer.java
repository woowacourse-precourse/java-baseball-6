package baseball.domain;

public class ComputerPlayer implements MatchPlayer {

    private final AnswerNumbers answer;

    public ComputerPlayer(AnswerNumbersGenerator numberGenerator) {
        this.answer = numberGenerator.create();
    }

    @Override
    public BaseBallHint requestHintOf(AnswerNumbers baseBallNumber) {
        final int ball = countBall(baseBallNumber);
        final int strike = countStrike(baseBallNumber);
        return new BaseBallHint(
                ball - strike,
                strike
        );
    }

    private int countBall(AnswerNumbers answerNumbers) {
        int ballCount = 0;
        for (int number : answerNumbers.get()) {
            if(answer.isBall(number)) ballCount++;
        }
        return ballCount;
    }

    private int countStrike(AnswerNumbers answerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < answerNumbers.size() ; i++) {
            int number = answerNumbers.get().get(i);
            if (answer.isStrike(number, i)) strikeCount++;
        }
        return strikeCount;
    }
}
