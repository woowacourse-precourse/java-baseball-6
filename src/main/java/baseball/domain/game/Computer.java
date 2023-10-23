package baseball.domain.game;

import baseball.domain.ball.Answer;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.Guess;
import baseball.domain.ball.GuessResult;

public final class Computer {
    private final AnswerCreator answerCreator;

    private Answer answer;

    public Computer(final AnswerCreator answerCreator) {
        this.answerCreator = answerCreator;
    }

    public void resetAnswer() {
        answer = answerCreator.create();
    }

    public GuessResult check(final Guess guess) {
        return answer.compare(guess);
    }
}
