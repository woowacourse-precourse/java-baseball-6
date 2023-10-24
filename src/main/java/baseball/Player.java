package baseball;

import java.util.*;

public class Player {

    private final List<Integer> computer;

    private final List<Integer> userNumberList;

    private final int size;

    private final int strike;

    private final int ball;

    public Player(List<Integer> computer, List<Integer> userNumberList, int size) {
        this.computer = computer;
        this.userNumberList = userNumberList;
        this.size = size;
        this.strike = countStrike();
        this.ball = countBall();
    }

    private int countStrike() {
        int cnt = 0;

        for (int i=0; i<size; i++) {
            if (Objects.equals(computer.get(i), userNumberList.get(i))) cnt++;
        }

        return cnt;
    }

    public int getStrike() {
        return strike;
    }

    private int countBall() {
        int cnt = 0;

        for (int i=0; i<size; i++) {
            if (!Objects.equals(computer.get(i), userNumberList.get(i)) && computer.contains(userNumberList.get(i))) cnt++;
        }

        return cnt;
    }

    public int getBall() {
        return ball;
    }

    public void printResult() {
        String result;
        if (strike == 0 && ball == 0) {
            result = BaseBall.NOTHING.command();
        } else if (strike > 0 && ball == 0) {
            result = strike + BaseBall.STRIKE.command();
        } else if (strike == 0 && ball > 0) {
            result = ball + BaseBall.BALL.command();
        } else {
            result = ball + BaseBall.BALL.command() + " " + strike + BaseBall.STRIKE.command();
        }
        System.out.println(result);
    }
}
