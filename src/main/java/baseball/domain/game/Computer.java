package baseball.domain.game;

import baseball.domain.ball.Answer;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.Guess;

public final class Computer {
    private final AnswerCreator answerCreator;

    private Answer answer;

    public Computer(final AnswerCreator answerCreator) {
        this.answerCreator = answerCreator;
    }

    public void createAnswer() {
        answer = answerCreator.create();
    }

    public GameResult check(final Guess guess) {
        return new GameResult(
                answer.countBalls(guess),
                answer.countStrikes(guess)
        );
    }
}
