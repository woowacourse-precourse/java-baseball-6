package baseball.view.core;

import baseball.event.EventListener;
import baseball.view.part.GameStartView;
import baseball.view.part.InitializeComputerView;
import baseball.view.part.InitializeUserView;
import baseball.view.part.RefereeView;
import baseball.view.part.RetryGameView;
import java.util.Map;

public final class ViewContainer {

    private final Map<ViewType, DefaultView> viewMap;

    public ViewContainer(
            InputView inputView,
            OutputView outputView,
            EventListener eventListener
    ) {
        this.viewMap = Map.of(
                ViewType.GAME_START, new GameStartView(outputView),
                ViewType.COMPUTER_INIT, new InitializeComputerView(eventListener),
                ViewType.PLAYER_INIT, new InitializeUserView(inputView, eventListener),
                ViewType.REFEREE, new RefereeView(eventListener, outputView),
                ViewType.RETRY, new RetryGameView(inputView)
        );
    }

    public DefaultView findView(ViewType viewType) {
        return this.viewMap.get(viewType);
    }
}
