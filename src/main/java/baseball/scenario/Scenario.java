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

    enum ScenarioResultType {
        PREVIOUS,
        NEXT,
        REPEAT,
    }

    interface ScenarioAction {
        ScenarioResultType execute();
    }

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
