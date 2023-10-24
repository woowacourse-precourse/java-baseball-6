package baseball;

import camp.nextstep.edu.missionutils.Console;

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
        if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike > 0 && ball == 0) System.out.println(strike + "스트라이크");
        else if (strike == 0 && ball > 0) System.out.println(ball + "볼");
        else if (strike > 0 && ball > 0) System.out.println(ball + "볼" + " " + strike + "스트라이크");
    }
}
