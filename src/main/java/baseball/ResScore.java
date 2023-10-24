package baseball;

public class ResScore {
    int ball, strike, nothing;

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }

    public int getNothing() {
        return nothing;
    }

    public void initScore(){
        setBall(0);
        setStrike(0);
        setNothing(0);
    }

    public void printScore(){
        if(getStrike() ==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(getNothing() ==1){
            System.out.println("낫싱");
        }
        else if(getBall() ==0){
            System.out.println(getStrike()+"스트라이크");
        }
        else if(getStrike() ==0){
            System.out.println(getBall()+"볼");
        }else{
            System.out.println(getBall()+"볼 "+getStrike()+"스트라이크");
        }
    }
}
