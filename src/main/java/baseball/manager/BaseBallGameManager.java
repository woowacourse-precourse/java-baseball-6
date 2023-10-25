package baseball.manager;

import baseball.application.BaseBallGame;
import baseball.controller.BaseBallGameController;
import baseball.controller.Game;
import baseball.controller.dto.BaseBallGameDto;
import baseball.domain.BaseBallNumberList;
import baseball.ui.UIFacade;

public class BaseBallGameManager implements GameManager {

    private final UIFacade ui;
    private final RandomNumberGenerator randomNumberGenerator;
    private boolean exit;

    public BaseBallGameManager(UIFacade ui,
            RandomNumberGenerator randomNumberGenerator) {
        this.ui = ui;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void exit() {
        exit = true;
    }

    @Override
    public void execute() {
        ui.rendering(GameOutputTemplate.FIRST_START.toString());
        executePerform();
    }

    private void executePerform() {
        initExit();
        Game game = new BaseBallGameController(
                new BaseBallGame(new BaseBallNumberList(
                        randomNumberGenerator.pickUniqueNumbersInRange(1, 9, 3)
                ),
                        this));

        while (!isExit()) {
            ui.rendering(GameOutputTemplate.INPUT.toString());
            ui.rendering(game.play(new BaseBallGameDto(ui.intercept())) + "\n");
        }

        ui.rendering(GameOutputTemplate.EXIT.toString());
        ui.rendering(GameOutputTemplate.REPLAY.toString());

        Command command = new Command(ui.intercept());
        if (command.replay()) {
            executePerform();
        }
    }

    private void initExit() {
        exit = false;
    }

    private boolean isExit() {
        return exit;
    }
}
