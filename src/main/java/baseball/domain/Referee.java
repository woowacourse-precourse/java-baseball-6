package baseball.domain;

import baseball.view.OutputView;

public class Referee {

    private Computer computer;

    private Player player;

    private int strike;

    private int ball;

    public Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        this.strike = 0;
        this.ball = 0;
    }

    public void checkResult(){
        init();
        checkStrike();
        checkBall();
    }

    void init(){
        this.strike = 0;
        this.ball = 0;
    }

    int checkStrike(){
        for(int i=0; i<computer.getNumber().size(); i++){
            for(int j=0; j<player.getNumber().size(); j++){
                if(computer.getNumber().get(i) == player.getNumber().get(j) && i==j){
                    this.strike++;
                }
            }
        }
        return strike;
    }

    int checkBall(){
        for(int i=0; i<computer.getNumber().size(); i++){
            for(int j=0; j<player.getNumber().size(); j++){
                if(computer.getNumber().get(i) == player.getNumber().get(j) && i!=j){
                    this.ball++;
                }
            }
        }
        return ball;
    }

    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }
}
