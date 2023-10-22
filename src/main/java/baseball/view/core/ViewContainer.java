package baseball.view.core;

import baseball.view.part.GameStartView;
import java.util.HashMap;
import java.util.Map;

public final class ViewContainer {
    private final InputView inputView;
    private final OutputView outputView;

    private final Map<ViewType, DefaultView> viewMap;

    public ViewContainer(
            InputView inputView,
            OutputView outputView
    ) {
        this.inputView = inputView;
        this.outputView = outputView;

        this.viewMap = new HashMap<>() {{
            this.put(ViewType.GAME_START, new GameStartView(outputView));

        }};
    }

    public DefaultView findView(ViewType viewType) {
        return this.viewMap.get(viewType);
    }
}
