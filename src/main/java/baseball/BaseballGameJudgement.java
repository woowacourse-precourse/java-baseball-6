package baseball;

public class BaseballGameJudgement {

    private int ball = 0;
    private int strike = 0;

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    public void printJudgement() {
        StringBuilder sb = new StringBuilder();
        if(ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if(strike != 0) {
            sb.append(strike).append("스트라이크 ");
        }
        if(sb.isEmpty()) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

}
