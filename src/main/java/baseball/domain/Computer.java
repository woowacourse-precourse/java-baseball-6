package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer extends GameComputer {

    private Set<Ball> balls;

    private Computer() {
        this.balls = new LinkedHashSet<>();
        setUpGame();
    }

    public static Computer startComputer() {
        return new Computer();
    }

    @Override
    public void setUpGame() {
        while (balls.size() < maxNumberOfBallsAmount) {
            int randomNumber = pickBall(minValueOfBall, maxValueOfBall);
            balls.add(new Ball(randomNumber));
        }
    }

    public Integer pickBall(int minValueOfBall, int maxValueOfBall) {
        return Randoms.pickNumberInRange(minValueOfBall, maxValueOfBall);
    }

    public int processHint(Ball ball, int givenOrder) {
        int answerBallOrder = 0;
        for (Ball computerBall : balls) {
            if (ball.equals(computerBall)) {
                return checkOrder(answerBallOrder, givenOrder);
            }
            answerBallOrder++;
        }
        return nothingHit;
    }

    private Integer checkOrder(int answerBallOrder, int givenOrder) {
        if (answerBallOrder == givenOrder) {
            return strikeHit;
        }
        return ballHit;
    }
    public void showHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}









