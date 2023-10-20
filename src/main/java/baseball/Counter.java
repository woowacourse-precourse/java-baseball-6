package baseball;

import java.util.stream.IntStream;

public class Counter {
    private int ball;
    private int strike;

    public void addBall() {
        ball++;
    }

    public void addStrike() {
        strike++;
    }

    public boolean isCorrect() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱\n");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }

    public void checkCounts(int[] com, int[] user, Counter counter) {
        IntStream.range(0, user.length).forEach(i -> {
            if (user[i] == com[i]) {
                counter.addStrike();
            } else {
                IntStream.range(0, com.length).filter(j -> user[i] == com[j]).forEach(j -> counter.addBall());
            }
        });
    }
}
