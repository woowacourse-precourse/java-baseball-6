package baseball;

import baseball.scenario.Scenario;
import baseball.view.core.ViewContainer;
import baseball.view.core.ViewType;

public record BaseballApplication(ViewContainer viewContainer) {

    public void run() {
        gameStartScenario().play();
    }

    Scenario gameStartScenario() {
        final var view = viewContainer.findView(ViewType.GAME_START);
        return Scenario.create()
                .next(this::initializeComputer)
                .build(view::execute);
    }

    Scenario initializeComputer() {
        final var view = viewContainer.findView(ViewType.COMPUTER_INIT);
        return Scenario.create()
                .next(this::initializeUser)
                .build(view::execute);
    }

    Scenario initializeUser() {
        final var view = viewContainer.findView(ViewType.PLAYER_INIT);
        return Scenario.create()
                .next(this::refereeScenario)
                .build(view::execute);
    }

    Scenario refereeScenario() {
        final var view = viewContainer.findView(ViewType.REFEREE);
        return Scenario.create()
                .previous(this::initializeUser)
                .next(this::retryScenario)
                .build(view::execute);
    }

    Scenario retryScenario() {
        final var view = viewContainer.findView(ViewType.RETRY);
        return Scenario.create()
                .previous(this::initializeComputer)
                .build(view::execute);
    }
}