package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutPutView;

public class Game {

    private GameManager manager = new GameManager();
    private Numbers systemNumber;

    public void play() {
        OutPutView.printStartMessage();
        do {
            init();
            gameStart();
        } while(restart());
    }

    private void init() {
        this.systemNumber = new Numbers(SystemNumbersManager.createSystemNumbers());
    }

    private void gameStart() {
        do {
            Numbers player = InputView.inputNumber();
        } while (false);
        OutPutView.printEndMessage();
    }

    public boolean restart() {
        return manager.reStartGame();
    }
}
