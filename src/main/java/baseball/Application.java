package baseball;

import baseball.event.EventContext;
import baseball.event.EventListener;
import baseball.view.core.InputView;
import baseball.view.core.OutputView;
import baseball.view.core.ViewContainer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final var viewContainer = new ViewContainer(
                new InputView(),
                new OutputView(),
                new EventListener(new EventContext())
        );
        
        new BaseballApplication(viewContainer).run();
    }
}
