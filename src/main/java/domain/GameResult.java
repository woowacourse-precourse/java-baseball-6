package domain;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.strike == 0){
            return "낫싱";
        }
        appendBallCount(sb);
        appendStrikeCount(sb);
        return sb.toString();
    }

    private void appendBallCount(StringBuilder sb) {
        if(ball != 0){
            sb.append(ball).append("볼").append(" ");
        }
    }

    private void appendStrikeCount(StringBuilder sb) {
        if(strike != 0){
            sb.append(strike).append("스트라이크");
        }
    }


}
