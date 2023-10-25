package baseball.people.preparation;

import static baseball.people.Message.BALL;
import static baseball.people.Message.GAME_END;
import static baseball.people.Message.GAME_START;
import static baseball.people.Message.NOTHING;
import static baseball.people.Message.STRIKE;

import java.util.List;

public class Referee {
    private TargetNumber targetNumber;

    private Referee() {
    }

    /**
     * Referee 객체를 생성하는 정적 팩토리 메서드
     *
     * @return Referee 객체
     */
    public static Referee enter() {
        System.out.println(GAME_START.getMessage());
        return new Referee();
    }

    /**
     * 주어진 3자리 정수 배열이 3스트라이크인지 판별하는 메서드 값을 반환하기 전에 볼과 스트라이크의 개수를 출력한다.
     *
     * @param numbers 크기가 3인 정수 리스트
     * @return 3스트라이크면 true, 그렇지 않으면 false
     */
    public boolean strikeOut(List<Integer> numbers) {
        int ball = 0, strike = 0;
        for (int i = 0; i < 3; i++) {
            if (targetNumber.isStrike(numbers.get(i), i)) {
                strike++;
                continue;
            }
            if (targetNumber.isBall(numbers.get(i))) {
                ball++;
            }
        }

        declare(ball, strike);

        return strike == 3;
    }

    /**
     * 멤버 변수 targetNumber를 재설정하는 메서드
     */
    public void playBall() {
        targetNumber = TargetNumber.generate(0, 0, 0);
    }

    private void declare(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING.getMessage());
            return;
        }

        StringBuilder print = new StringBuilder();
        if (ball > 0) {
            print.append(String.format(BALL.getMessage(), ball));
        }
        if (strike > 0) {
            print.append(String.format(STRIKE.getMessage(), strike));
        }

        System.out.println(print);

        if (strike == 3) {
            System.out.println(GAME_END.getMessage());
        }
    }
}
