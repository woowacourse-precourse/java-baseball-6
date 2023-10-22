package baseball.controller;

import baseball.model.Score;

import java.util.List;

public class Calculator {
    private final static int MAX_SIZE = 3;
    public Calculator() {}

    public Score getScore(List<Integer> computer, List<Integer> user) {
        int strike = calculateStrike(computer,user);
        int ball = calculateBall(computer,user);

        return new Score(strike,ball);
    }

    private int calculateStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i=0;i<MAX_SIZE;i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);

            if (compare(computerNumber,userNumber)) strike++;
        }
        return strike;
    }

    private int calculateBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        for (int i=0;i<MAX_SIZE;i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);
            if (computer.contains(userNumber) && !compare(computerNumber,userNumber) ) ball++;
        }
        return ball;
    }

    private boolean compare(int computer, int user) {
        return computer==user;
    }



}
