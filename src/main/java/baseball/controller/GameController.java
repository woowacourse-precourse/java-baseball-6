package baseball.controller;

import baseball.model.pitcher.ComputerPitcher;
import baseball.model.pitcher.Pitcher;
import baseball.model.restarter.RestartState;
import baseball.model.umpire.Umpire;
import baseball.model.vo.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private InputView in;
    private OutputView out;
    private Pitcher pitcher;

    public GameController() {
        in = new InputView();
        out = new OutputView();
        pitcher = new ComputerPitcher();
    }

    public void run() {
        out.displayStartMessage();
        while (true) {
            startGame();
            RestartState state = RestartState.findState(in.inputRestartNumber());
            if (state.isEndGame()) {
                break;
            }
        }
    }

    private void startGame() {
        Umpire umpire = Umpire.create();
        BaseballNumber pitcherNumber = pitcher.generate();
        while (true) {
            BaseballNumber hitterNumber = BaseballNumber.of(in.inputBaseballNumber());

            umpire.determineStrikeAndBall(pitcherNumber, hitterNumber);
            out.displayResult(umpire.getStrike(), umpire.getBall());

            if (umpire.isStrikeOut()) {
                break;
            }
        }
        out.displayEndMessage();
    }
}
