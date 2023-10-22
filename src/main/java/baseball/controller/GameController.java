package baseball.controller;

import baseball.application.RefereeService;
import baseball.domain.GameButton;
import baseball.domain.Pitch;
import baseball.dto.Inning;
import baseball.factory.PitchFactory;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class GameController {
    private final InputView inputView;
    private final PitchFactory pitchFactory;
    private final OutputView outputView;
    private final RefereeService referee;

    public GameController(InputView inputView, PitchFactory pitchFactory, OutputView outputView,
                          RefereeService referee) {
        this.inputView = inputView;
        this.pitchFactory = pitchFactory;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void play() {
        GameButton gameButton = new GameButton();
        Pitch computer = pitchFactory.create();

        outputView.printGameStartMessage();
        while (gameButton.isPlay()) {
            Pitch player = getPlayer();
            Inning inning = referee.compare(player, computer);
            outputView.printResult(inning);
            computer = playNewGame(inning, gameButton, computer);
        }
    }

    private Pitch getPlayer() {
        String input = inputView.scanNumbers();
        return pitchFactory.create(input);
    }

    private Pitch playNewGame(Inning inning, GameButton gameButton, Pitch computer) {
        if (inning.isThreeStrike()) {
            outputView.printGameEndMessage();
            String input = inputView.scanRestartNumber();
            gameButton.changeButton(input);
            computer = createNewComputer(gameButton, computer);
        }
        return computer;
    }

    private Pitch createNewComputer(GameButton gameButton, Pitch computer) {
        if (gameButton.isPlay()) {
            computer = pitchFactory.create();
        }
        return computer;
    }
}