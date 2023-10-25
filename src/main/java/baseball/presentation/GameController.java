package baseball.presentation;

import baseball.application.service.GameFacade;
import baseball.constants.PrintConst;
import baseball.domain.entity.Hint;
import baseball.domain.service.HintCreateService;
import baseball.domain.service.PredictionCreateService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final HintCreateService hintCreateService;
    private final PredictionCreateService predictionCreateService;
    private final GameFacade gameFacade;

    public GameController(HintCreateService hintCreateService, PredictionCreateService predictionCreateService, GameFacade gameFacade) {
        this.hintCreateService = hintCreateService;
        this.predictionCreateService = predictionCreateService;
        this.gameFacade = gameFacade;
    }

    public void init() {
        System.out.println(PrintConst.START.getMessage());
        gameFacade.startGame();
    }

    public void progress() {
        while (!gameFacade.progressing()) {
            System.out.print(PrintConst.INPUT.getMessage());
            final String input = Console.readLine();
            final Hint hint = gameFacade.generateHint(input);

            System.out.println(hint);
            checkSuccess(hint);
        }

    }

    private void checkSuccess(final Hint hint) {
        if (hint.isSuccess()) {
            System.out.println(PrintConst.END.getMessage());
            System.out.println(PrintConst.RESULT.getMessage());
            final String input = Console.readLine();
            gameFacade.continueGame(input);
        }
    }
}
