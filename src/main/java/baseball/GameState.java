package baseball;

public class GameState {

    public static final int GAME_SUCCEED_STATE = 0;
    public static final int PROGRESS_STATE = 1;
    public static final int END_STATE = 2;
    private int gameSwitch;

    public GameState(int gameSwitch) {
        this.gameSwitch = gameSwitch;
    }

    public void checkGameSucceeded(int strike) {
        if (strike == 3) {
            gameSwitch = GAME_SUCCEED_STATE;
        }
    }

    public void checkGameRetryOrEnd(int retryOrEnd){
        if(retryOrEnd == PROGRESS_STATE){
            gameSwitch = PROGRESS_STATE;
        }
        if(retryOrEnd == END_STATE){
            gameSwitch = END_STATE;
        }
    }

    public int getState(){
        return gameSwitch;
    }
}
