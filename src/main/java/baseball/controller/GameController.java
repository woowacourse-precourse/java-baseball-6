package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Player;
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
        Player player = initPlayer();
        startGame(game, player);

        if(isRestartNumber()) {
            startProgram();
        }
    }

    private Game initGame() {
        GameService gameService = new GameService();
        return Game.numberOf(gameService.getRandomNumbers());
    }

    private Player initPlayer() {
        return new Player();
    }

    private void startGame(Game game, Player player) {
        inputNumber(player);
        game.compareNumber(player.getInputNumbers());
        printResult(game);

        if(!game.isThreeStrike()) {
            startGame(game, player);
        }
    }

    private void inputNumber(Player player) {
        player.setInputNumber(inputView.inputGameNumber());
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

    private boolean isRestartNumber() {
        return inputView.inputRestartNumber().equals("1");
    }
}
