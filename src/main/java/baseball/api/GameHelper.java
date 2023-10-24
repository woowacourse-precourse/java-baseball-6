package baseball.api;

import baseball.api.request.RequestChecker;
import baseball.api.request.SupportedRetryRequest;

public class GameHelper {

    public GameStarter startGame() {
        return new GameStarter(Computer.getResult(), false, this);
    }

    public void retryGame() throws IllegalArgumentException {
        SupportedRetryRequest request = RequestChecker.retryRequest();
        if(request.isFlag()) {
            reStartGame().run().retryGame();
        }
    }

    public GameStarter reStartGame() {
        return new GameStarter(Computer.getResult(), true, this);
    }
}
