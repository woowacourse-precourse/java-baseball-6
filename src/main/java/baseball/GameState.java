package baseball;

public class GameState {
    public static final GameState START = new GameState("START");
    public static final GameState IN_PROGRESS = new GameState("IN_PROGRESS");
    public static final GameState GAME_OVER = new GameState("GAME_OVER");

    private final String state;

    private GameState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }
}