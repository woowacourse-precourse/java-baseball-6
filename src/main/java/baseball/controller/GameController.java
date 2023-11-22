package baseball.controller;

import baseball.model.pitcher.ComputerPitcher;
import baseball.model.pitcher.Pitcher;
import baseball.model.umpire.Umpire;
import baseball.model.vo.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private InputView in;
    private OutputView out;
    private Pitcher pitcher;

    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    public GameController() {
        in = new InputView();
        out = new OutputView();
        pitcher = new ComputerPitcher();
    }

    public void run() {
        out.displayStartMessage();
        int restart = RESTART_GAME;
        while (restart == RESTART_GAME) {;
            startGame();

            restart = Integer.parseInt(in.inputRestartNumber());
        }
    }

    private void startGame() {
        Umpire umpire = Umpire.create();
        BaseballNumber pitcherNumber = pitcher.generate();
        while (!umpire.isStrikeOut()) {
            BaseballNumber hitterNumber = BaseballNumber.of(in.inputBaseballNumber());

            List<Integer> result = umpire.determineStrikeAndBall(pitcherNumber, hitterNumber);

            out.displayResult(result.get(0), result.get(1));
        }
        out.displayEndMessage();
    }
}
