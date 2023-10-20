package baseball.dto;

public class GameStateDto {

    private int strike;
    private int ball;

    private boolean restart;

    public GameStateDto() {
        this.strike = 0;
        this.ball = 0;
        this.restart = false;
    }

    public void addStrike(){
        this.strike=this.strike+1;
    }


    public void addBall(){
        this.ball=this.ball+1;
    }

    public void activateRestart(){
        this.restart=true;
    }

}
