package baseball.view.part;

import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.DefaultView;
import baseball.view.core.OutputView;

public record GameStartView(OutputView outputView) implements DefaultView {

    @Override
    public ScenarioResultType execute() {
        outputView.printGameStartMessage();

        return ScenarioResultType.NEXT;
    }
}
