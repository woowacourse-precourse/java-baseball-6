package baseball.factory;

import baseball.controller.Dispatcher;
import baseball.dto.HintDTO;
import baseball.util.View;

public class GameFactory {

    private final Dispatcher dispatcher;

    private static GameFactory INSTANCE;

    private GameFactory(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static GameFactory getInstance(Dispatcher dispatcher) {
        if (INSTANCE == null) {
            INSTANCE = new GameFactory(dispatcher);
        }
        return INSTANCE;
    }

    public void start() {
        View.printStartMessage();
        process();
    }

    private void process() {
        dispatcher.dispatchGameStart();

        while (true) {
            HintDTO judge = dispatcher.dispatchProcess(View.input());
            View.printMessage(judge.getMessage());
            if (judge.isAllStrike()) {
                if (!isRetry()) {
                    break;
                }
            }
        }
    }

    private boolean isRetry() {
        if (dispatcher.dispatchRetry(View.retry())) {
            dispatcher.dispatchGameStart();
            return true;
        }
        return false;
    }

}
