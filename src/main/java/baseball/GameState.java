package baseball;

public class GameState {


    //public static final int SELECTING_STATE = 0;
    public static final int PROGRESS_STATE = 1;
    public static final int END_STATE = 2;
    public int gameSwitch;

    public GameState(int gameSwitch) {
        this.gameSwitch = gameSwitch;
    }

    /*public void foundAnswer(int strike) {
        if (strike == 3) {
            gameSwitch = SELECTING_STATE;
        }
    }

    public void retry(int retryOrEnd) {
        if (retryOrEnd == PROGRESS_STATE) {
            gameSwitch = PROGRESS_STATE;
        }
    }

    public void end(int retryOrEnd) {
        if (retryOrEnd == END_STATE) {
            gameSwitch = END_STATE;
        }
    }

    public int getState() {
        return gameSwitch;
    }*/
}
