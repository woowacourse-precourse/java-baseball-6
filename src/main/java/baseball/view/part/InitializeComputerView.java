package baseball.view.part;

import baseball.domain.Computer;
import baseball.event.EventContext;
import baseball.event.EventListener;
import baseball.event.EventListener.Event;
import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.DefaultView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public record InitializeComputerView(EventListener eventListener) implements DefaultView {
    @Override
    public ScenarioResultType execute() {

        eventListener.listen(InitializeComputerEvent::new);
        return ScenarioResultType.NEXT;
    }

    public record InitializeComputerEvent(EventContext eventContext) implements Event {
        private static final int MIN_NUMBER = 1;
        private static final int MAX_NUMBER = 9;
        private static final int SIZE = 3;

        @Override
        public void execute() {
            eventContext.initializeComputer(new Computer(generateRandomNumbers()));
        }

        private List<Integer> generateRandomNumbers() {
            return IntStream.iterate(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER),
                            (i) -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
                    .distinct()
                    .limit(SIZE)
                    .boxed()
                    .toList();
        }
    }
}
