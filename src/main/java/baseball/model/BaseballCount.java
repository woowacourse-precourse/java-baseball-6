package baseball.model;

import java.util.List;

public class BaseballCount {
    private int strikeCount;
    private int ballCount;

    public BaseballCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void addBallCount() {
        ballCount++;
    }

    public int countStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        for(int idx = 0; idx < userNumberList.size(); idx++) {
            if(computerNumberList.get(idx).equals(userNumberList.get(idx))) {
                addStrikeCount();
            }
        }
        return strikeCount;
    }

    public int countBall(List<Integer> computerNumberList, List<Integer> userNumberList) {
        for(int idx = 0; idx < userNumberList.size(); idx++) {
            if(!computerNumberList.get(idx).equals(userNumberList.get(idx)) && userNumberList.contains(computerNumberList.get(idx))) {
                addBallCount();
            }
        }
        return ballCount;
    }

    public void printCountResult(int ball, int strike) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return ;
        }
        if(strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if(strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if(ball > 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
        }
    }
}
