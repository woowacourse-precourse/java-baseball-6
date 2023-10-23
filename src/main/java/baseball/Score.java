package baseball;

public class Score {
    private int strike;
    private int ball;
    private boolean nothing;

    public Score(){
        this.strike = 0;
        this.ball = 0;
        this.nothing = false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
    public boolean getNothing(){
        return nothing;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }
    public void setBall(int ball){
        this.ball=ball;
    }
    public void setNothing(boolean b){
        this.nothing = b;
    }

    public boolean print(Score score){
        int strike = score.getStrike();
        int ball = score.getBall();
        boolean nothing = score.getNothing();

        if(strike == 3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if(nothing){
            System.out.println("낫싱");
        }
        else if(strike==0){
            System.out.println(ball+"볼");
        }
        else if(ball==0){
            System.out.println(strike+"스트라이크");
        }
        else{
            System.out.println(ball+"볼 " + strike + "스트라이크");
        }
        return false;
    }
}

