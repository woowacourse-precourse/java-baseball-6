package baseball;

public enum GameStatus {

    PLAY(1),
    FINISH(2);
    public final int status;
    GameStatus(int status){
        this.status = status;
    }
}
