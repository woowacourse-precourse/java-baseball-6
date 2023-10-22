package baseball;

public class GameContext {

    private static final String END_POINT = "2";
    private boolean gameContext;

    public GameContext(boolean gameContext) {
        this.gameContext = gameContext;
    }

    public boolean isGameContext() {
        return gameContext;
    }

    public void updateContext(String input) {
        if (input.equals(END_POINT)) {
            gameContext = false;
        }
    }
}
