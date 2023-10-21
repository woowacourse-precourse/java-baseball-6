package baseball;

public class GameState {
    public static final int PROGRESS_STATE = 1;
    public static final int END_STATE = 2;
    public int gameSwitch;

    public GameState(int gameSwitch) {
        this.gameSwitch = gameSwitch;
    }

}
