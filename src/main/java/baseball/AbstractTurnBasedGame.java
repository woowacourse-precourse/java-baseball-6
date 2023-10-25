package baseball;

public abstract class AbstractTurnBasedGame implements Game {
    public void start() {
        onGameStarted();
        do {
            onRoundStarted();
            do {
                onTurnStarted();
                onTurnEnded();
            }
            while (hasNextTurn());
            onRoundEnded();
        }
        while (hasNextRound());
        onGameEnded();
    }

    protected void onGameStarted() {}
    protected void onGameEnded() {}
    protected void onRoundStarted() {}
    protected void onRoundEnded() {}
    protected void onTurnStarted() {}
    protected void onTurnEnded() {}
    protected abstract boolean hasNextRound();
    protected abstract boolean hasNextTurn();
}
