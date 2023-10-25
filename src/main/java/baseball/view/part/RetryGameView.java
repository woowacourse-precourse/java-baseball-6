package baseball.view.part;

import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.DefaultView;
import baseball.view.core.InputView;

public record RetryGameView(InputView inputView) implements DefaultView {
    
    @Override
    public ScenarioResultType execute() {
        return switch (inputView.readRetryCommand()) {
            case 1 -> ScenarioResultType.PREVIOUS;
            case 2 -> ScenarioResultType.NEXT;
            default -> throw new IllegalArgumentException("1과 2를 제외한 명령어는 허용하지 않습니다.");
        };
    }
}
