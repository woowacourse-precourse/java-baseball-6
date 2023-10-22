package baseball.singlegame;

import baseball.domain.AnswerNumbers;
import baseball.domain.AnswerNumbersGenerator;
import baseball.domain.BaseBallHint;
import baseball.domain.MatchPlayer;

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
        return answer.count(answerNumbers::isBall);
    }

    private int countStrike(AnswerNumbers answerNumbers) {
        return answer.countWithIndex(answerNumbers::isStrike);
    }
}
