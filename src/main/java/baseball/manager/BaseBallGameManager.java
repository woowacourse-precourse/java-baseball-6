package baseball.manager;

import baseball.application.BaseBallGame;
import baseball.controller.BaseBallGameController;
import baseball.controller.Game;
import baseball.domain.BaseBallNumberList;
import baseball.ui.InputUserInterface;
import baseball.ui.OutputUserInterface;

public class BaseBallGameManager implements GameManager {

    private final InputUserInterface inputUI;
    private final OutputUserInterface outputUI;
    private final RandomNumberGenerator randomNumberGenerator;
    private boolean exit;

    public BaseBallGameManager(InputUserInterface inputUI, OutputUserInterface outputUI,
            RandomNumberGenerator randomNumberGenerator) {
        this.inputUI = inputUI;
        this.outputUI = outputUI;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void execute() {
        outputUI.print(GameOutputTemplate.FIRST_START.toString());
        executePerform();
    }

    private void executePerform() {
        exit = false;
        Game game = new BaseBallGameController(
                new BaseBallGame(new BaseBallNumberList(
                        randomNumberGenerator.pickUniqueNumbersInRange(1, 9, 3)
                ),
                        this));

        while (!exit) {
            outputUI.print(GameOutputTemplate.INPUT.toString());
            outputUI.print(game.play(inputUI.intercept()) + "\n");
        }

        outputUI.print(GameOutputTemplate.EXIT.toString());
        outputUI.print(GameOutputTemplate.REPLAY.toString());

        Command command = new Command(inputUI.intercept());
        if (command.replay()) {
            executePerform();
        }
    }


    @Override
    public void exit() {
        exit = true;
    }
}
