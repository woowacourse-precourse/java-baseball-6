package baseball.dto;

public class GameStateDto {

    private int strike;
    private int ball;

    private boolean endGame;

    private boolean restart;

    public boolean isEndGame() {
        return endGame;
    }

    public GameStateDto() {
        this.strike = 0;
        this.ball = 0;
        this.restart = false;
        this.endGame = false;
    }

    public void addStrike(){
        this.strike=this.strike+1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isRestart() {
        return restart;
    }

    public void addBall(){
        this.ball=this.ball+1;
    }

    public void activateRestart(){
        this.restart=true;
    }

    public void activateEndGame() {
        this.endGame=true;
    }
}
