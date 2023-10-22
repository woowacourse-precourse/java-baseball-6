package baseball.controller;

import baseball.domain.Game;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void manageProgram() {
        startProgram();
    }

    private void startProgram() {
        outputView.outputStartProgram();
        Game game = initGame();
        startGame(game);

        if(inputView.inputRestartNumber().equals("1")) {
            startProgram();
        }
    }

    private Game initGame() {
        GameService gameService = new GameService();
        return Game.numberOf(gameService.getRandomNumbers());
    }

    private void startGame(Game game) {
        inputNumber(game);
        compareNumber(game);
        printResult(game);

        if(!game.isThreeStrike()) {
            startGame(game);
        }
    }

    private void inputNumber(Game game) {
        game.setInputNumber(inputView.inputNumber());
    }

    private void compareNumber(Game game) {
        game.compareNumber();
    }

    private void printResult(Game game) {
        if(game.isThreeStrike()) {
            outputView.outputOnlyStrike(game.getStrikeNumber());
            outputView.outputEndProgram();
            return;
        }

        if(game.isOnlyStrike()) {
            outputView.outputOnlyStrike(game.getStrikeNumber());
            return;
        }

        if(game.isOnlyBall()) {
            outputView.outputOnlyBall(game.getBallNumber());
            return;
        }

        if(game.isNothing()) {
            outputView.outputNothing();
            return;
        }

        outputView.outputBallStrike(game.getBallNumber(), game.getStrikeNumber());
    }
}
