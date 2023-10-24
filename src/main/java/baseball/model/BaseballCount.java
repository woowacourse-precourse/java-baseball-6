package baseball.model;

import java.util.List;

public class BaseballCount {

    public int countStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strike = 0;
        for(int idx = 0; idx < userNumberList.size(); idx++) {
            if(computerNumberList.get(idx).equals(userNumberList.get(idx))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int ball = 0;
        for(int idx = 0; idx < userNumberList.size(); idx++) {
            if(!computerNumberList.get(idx).equals(userNumberList.get(idx)) && userNumberList.contains(computerNumberList.get(idx))) {
                ball++;
            }
        }
        return ball;
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
