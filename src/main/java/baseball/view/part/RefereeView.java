package baseball.view.part;

import baseball.event.EventContext;
import baseball.event.EventListener;
import baseball.event.EventListener.ReturnEvent;
import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.DefaultView;
import baseball.view.core.OutputView;
import java.util.Objects;
import java.util.stream.IntStream;

public record RefereeView(EventListener eventListener, OutputView outputView) implements DefaultView {
    @Override
    public ScenarioResultType execute() {
        final var score = eventListener.listenWithResult(RefereeEvent::new);
        outputView.printScore(score.getScoreText());
        if (score.isTreeStrike()) {
            outputView.printGameEnd();
            return ScenarioResultType.NEXT;
        }
        return ScenarioResultType.PREVIOUS;
    }


    public record RefereeEvent(EventContext eventContext) implements ReturnEvent<Score> {
        private static final int SIZE = 3;

        @Override
        public Score execute() {
            final var computerNumber = eventContext.getComputer().numbers();
            final var userNumber = eventContext.getUser().numbers();

            final var strikeCount = (int) IntStream.range(0, SIZE)
                    .filter(i -> Objects.equals(computerNumber.get(i), userNumber.get(i)))
                    .count();
            final var ballCount = IntStream.range(0, SIZE)
                    .map(i -> (int) IntStream.range(0, SIZE)
                            .filter(j -> j != i)
                            .filter(j -> Objects.equals(computerNumber.get(i), userNumber.get(j)))
                            .count())
                    .sum();
            return new Score(strikeCount, ballCount);
        }
    }

    public record Score(int strike, int ball) {

        boolean isTreeStrike() {
            return strike == 3;
        }

        String getScoreText() {
            final var stringBuilder = new StringBuilder();

            if (strike == 0 && ball == 0) {
                stringBuilder.append("낫싱");
            }
            if (ball > 0) {
                stringBuilder.append(ball).append("볼 ");
            }
            if (strike > 0) {
                stringBuilder.append(strike).append("스트라이크");
            }
            return stringBuilder.toString().trim();
        }
    }
}
