package baseball;

public class Baseball {

    private int strike;
    private int ball;

    public Baseball() {
        strike=0;
        ball=0;
    }

    public void updateStrike() {
        this.strike++;
    }
    public void updateBall() {
        this.ball++;
    }

    public boolean isOut(){
        return strike == 3;
    }
    public void print(){

        StringBuilder sb = new StringBuilder();

        if (this.ball != 0) sb.append(this.ball).append("볼 ");

        if (this.strike != 0) sb.append(this.strike).append("스트라이크 ");

        if(this.ball==0&&this.strike==0) sb.append("낫싱");

        System.out.println(sb);
    }

}
