package baseball.view.part;

import baseball.domain.User;
import baseball.event.EventContext;
import baseball.event.EventListener;
import baseball.event.EventListener.ParameterEvent;
import baseball.scenario.Scenario.ScenarioResultType;
import baseball.view.core.DefaultView;
import baseball.view.core.InputView;

public record InitializeUserView(InputView inputView, EventListener eventListener) implements DefaultView {
    
    @Override
    public ScenarioResultType execute() {
        eventListener.listenWithParameter(InitializeUserEvent::new)
                .accept(inputView.readUserInput());

        return ScenarioResultType.NEXT;
    }


    public record InitializeUserEvent(EventContext eventContext) implements ParameterEvent<String> {

        @Override
        public void execute(String input) {
            eventContext.initializeUser(new User(input));
        }
    }
}
