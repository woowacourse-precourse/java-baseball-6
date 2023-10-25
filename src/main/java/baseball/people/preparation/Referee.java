package baseball.people.preparation;

import static baseball.people.Message.GAME_END;
import static baseball.people.Message.GAME_START;

import baseball.people.Message;
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

        System.out.println(Message.getBallStrikeMessage(ball, strike));
        if (strike == 3) {
            System.out.println(GAME_END.getMessage());
            return true;
        }

        return false;
    }

    /**
     * 멤버 변수 targetNumber를 재설정하는 메서드
     */
    public void playBall() {
        targetNumber = TargetNumber.generate(0, 0, 0);
    }
}
