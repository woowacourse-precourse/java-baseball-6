package baseball.domain;

public class NumberBaseballGame {
    private Boolean gameState;

    public Boolean stillPlayingGame() {
        return this.gameState;
    }

    public void startGame(){
        this.gameState = Boolean.TRUE;
    }

    public void closeGame(){
        this.gameState = Boolean.FALSE;
    }
}
