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
        System.out.println(countPrint());
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
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

    private String countPrint() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball);
            sb.append("볼 ");
            if (strike != 0) {
                sb.append(strike);
                sb.append("스트라이크");
                return sb.toString();
            }
            return sb.toString();
        }
        if (strike != 0) {
            sb.append(strike);
            sb.append("스트라이크");
            return sb.toString();
        }
        sb.append("낫싱");
        return sb.toString();
    }
}
