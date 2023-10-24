package baseball;

public class Game {

    private final int NUM_COUNT=3;
    private int[] computerAnswer;
    private int strike=0;
    private int ball=0;

    public Game(){
    }

    public void reset(){
        setStrike(0);
        setBall(0);
    }

    public void setComputerAnswer(){
        Number number=new Number();
        computerAnswer=number.makeComputerAnswer();
    }

    public int[] getComputerAnswer(){
        return computerAnswer;
    }

    void setStrike(int strike){
        this.strike=strike;
    }

    void setBall(int ball){
        this.ball=ball;
    }

    void increaseStrike(){
        this.strike++;
    }

    void increaseBall(){
        this.ball++;
    }

    int getStrike(){
        return this.strike;
    }

    int getBall(){
        return this.ball;
    }
}
