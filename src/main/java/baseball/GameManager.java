package baseball;

import baseball.view.View;

public class GameManager {

    private final View view;
    private final GameService gameService;

    public GameManager(View view, GameService gameService) {
        this.view = view;
        this.gameService = gameService;
    }

    public void startGame() {
        view.startGame();
        gameService.generateNumber();
    }

    public void play() {
        String input = view.playInputNumbers();
        view.printResult(gameService.getGameResult(input));
    }

    public boolean isWin() {
        return gameService.isWin();
    }

    public boolean isEnd() {
        if (!gameService.endOrRestartGame(view.endGameAndRestartInputNumber())) {
            gameService.generateNumber();
            return false;
        }

        return true;
    }

}
