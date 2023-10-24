package baseball.scenario;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public interface Scenario {
    static ConditionalScenarioBuilder create() {
        return new ConditionalScenarioBuilder();
    }

    void play();


    /**
     * 시나리오 유형
     * <p>previous: 지정한 이전 시나리오로 돌아감</p>
     * <p>next: 지정한 다음 시나리오로 돌아감</p>
     */
    enum ScenarioResultType {
        PREVIOUS,
        NEXT,
    }

    interface ScenarioAction {
        ScenarioResultType execute();
    }

    /**
     * @param scenarioAction 동작하는 기능
     * @param scenarioMap    저장된 시나리오
     */
    record ConditionalScenario(
            ScenarioAction scenarioAction,
            Map<ScenarioResultType, Supplier<Scenario>> scenarioMap
    ) implements Scenario {
        @Override
        public void play() {
            Optional.ofNullable(scenarioMap.get(scenarioAction.execute()))
                    .map(Supplier::get)
                    .ifPresent(Scenario::play);
        }
    }

    class ConditionalScenarioBuilder {

        private final Map<ScenarioResultType, Supplier<Scenario>> scenarioMap = new HashMap<>();

        public ConditionalScenarioBuilder previous(Supplier<Scenario> scenarioSupplier) {
            this.scenarioMap.put(ScenarioResultType.PREVIOUS, scenarioSupplier);
            return this;
        }

        public ConditionalScenarioBuilder next(Supplier<Scenario> scenarioSupplier) {
            this.scenarioMap.put(ScenarioResultType.NEXT, scenarioSupplier);
            return this;
        }

        public Scenario build(ScenarioAction scenarioAction) {
            return new ConditionalScenario(scenarioAction, scenarioMap);
        }
    }
}
