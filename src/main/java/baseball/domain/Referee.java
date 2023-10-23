package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Referee {
    private int strikeNumber = 0;
    private int ballNumber = 0;
    private int next = 1;

    public Referee() {
    }

    public Referee(List<BallStatus> ballStatuses) {
        this.strikeNumber = getBallStatusCount(ballStatuses, BallStatus.STRIKE);
        this.ballNumber = getBallStatusCount(ballStatuses, BallStatus.BALL);
    }

    private static int getBallStatusCount(List<BallStatus> ballStatuses, BallStatus strike) {
        return (int) ballStatuses.stream()
                .filter(ballStatus -> ballStatus.equals(strike))
                .count();
    }

    public void judge() {
        if (strikeNumber == 3) {
            System.out.println(String.format("%d스트라이크", strikeNumber));
            gameEnd();
            return;
        }
        if (strikeNumber > 0 && ballNumber == 0) {
            System.out.println(String.format("%d스트라이크", strikeNumber));
            return;
        }
        if (strikeNumber > 0 && ballNumber > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ballNumber, strikeNumber));
            return;
        }
        if (strikeNumber == 0 && ballNumber > 0) {
            System.out.println(String.format("%d볼", ballNumber));
            return;
        }
        System.out.println("낫싱");
    }

    private void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        next = Integer.parseInt(Console.readLine());
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getNext() {
        return next;
    }
}