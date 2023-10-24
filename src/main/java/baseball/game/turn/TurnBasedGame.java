package baseball.game.turn;

import baseball.game.Game;

public class TurnBasedGame implements Game {

    private final TurnBasedGameView turnBasedGameView;
    private final TurnBasedGameService turnBasedGameService;

    public TurnBasedGame(TurnBasedGameView turnBasedGameView, TurnBasedGameService turnBasedGameService) {
        this.turnBasedGameView = turnBasedGameView;
        this.turnBasedGameService = turnBasedGameService;
    }

    public void init() {
        turnBasedGameService.init();
    }

    public void play() {
        turnBasedGameView.printStart();

        while (true) {
            TurnResult turnResult = turnBasedGameService.playTurn(turnBasedGameView.requestTurnInput());
            turnBasedGameView.printResult(turnResult);
            if (turnResult.isGameCleared()) {
                turnBasedGameView.printClear();
                return;
            }
        }
    }
}
