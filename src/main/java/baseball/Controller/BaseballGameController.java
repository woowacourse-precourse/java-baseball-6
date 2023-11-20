package baseball.Controller;

import baseball.Service.BaseballGameRule;
import baseball.Service.BaseballGameStart;
import baseball.Service.BaseballReGame;
import baseball.View.InputView;

public class BaseballGameController {
    public void run() {
        startGameView();
        while(true){
            initGame();
            game();
            if(!reGame()){
                return;
            }
        }
    }

    private void startGameView() {
        InputView inputView = new InputView();
        inputView.startGame();
    }

    private void initGame() {
        BaseballGameStart baseballGameStart = new BaseballGameStart();
        baseballGameStart.run();
    }

    private void game() {
        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.run();
    }

    private boolean reGame() {
        BaseballReGame baseballReGame = new BaseballReGame();
        return baseballReGame.run();
    }
}
