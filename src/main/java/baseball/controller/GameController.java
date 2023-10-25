package baseball.controller;

import baseball.service.GameService;
import baseball.util.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private GameService gameService = new GameService();

    public void start() {

        OutputView.start();

        boolean exitFlag = false;

        while(!exitFlag) {

            play();

            exitFlag = InputView.askExit();
        }

        OutputView.exit();
    }


    public void play() {

        gameService.createAnswerBalls();

        while(true) {
            String userInput = InputView.askUserNumbers();
            Util.validateUserInput(userInput);

            gameService.play(userInput);

            OutputView.printScore(gameService.createScoreDto());

            if(gameService.isAnswer()) {
                break;
            }
        }
    }
}
