package baseball.game;

import java.util.NoSuchElementException;

public class GameDispatcherFactory {

    public static GameDispatcher create(String cmd) {

        if (cmd == "predict") {
            return new GameDispatcherImpl(new PredictGamePlay());
        }

        if (cmd == "start") {
            return new GameDispatcherImpl(new StartGamePlay());
        }

        throw new NoSuchElementException();
    }
}
