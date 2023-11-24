package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.model.Judgement;
import baseball.model.NumberMaker;
import baseball.model.Player;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final NumberMaker numberMaker = new NumberMaker();

    public void run() {
        output.showStartMessage();
        do {
            start();
        } while (isReStart());
    }

    private boolean isReStart() {
        GameStatus gameStatus = GameStatus.find(input.readCommand());
        return gameStatus.equals(GameStatus.RESTART);
    }

    private void start() {
        Computer computer = new Computer(numberMaker.makeComputerNumbers());
        Judgement judgement = new Judgement(computer);
        do {
            Player player = new Player(input.readPlayerNumbers());
            judgement.judge(player);
            output.showResult(judgement.getStrike(), judgement.getBall());
        } while (judgement.isProgress());
    }
}
