package baseball.game;

import static baseball.constant.ExceptionMessage.DUPLICATE;
import static baseball.constant.ExceptionMessage.LENGTH;
import static baseball.constant.ExceptionMessage.NUMBER;
import static baseball.constant.GameConstant.MAX_BALL_NUM;
import static baseball.constant.GameConstant.MIN_BALL_NUM;
import static baseball.constant.GameConstant.TOTAL_BALL_CNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

/**
 * {@summary 공 정보를 다룬다.}
 * <p>
 * Ball 클래스는 {@link GameManager}에서 공 정보를 다루기 위한 클래스이다. 한번 정해진 공 정보는 변경될 수 없기에 멤버 변수는 모두 final로 선언된다. 만들어진 공 정보와 외부에서
 * 입력되는 공 정보를 계산하는 {@link #calculate(String)}메서드만 외부에서 사용 가능하다.
 * <p>
 * game 패키지 내에서만 사용되므로 접근 제어자를 default로 선언하였다.
 *
 * @see GameManager
 */
class Ball {
    private final int[] balls;
    private final Set<Character> validation;

    public Ball() {
        this.balls = generate();
        this.validation = new HashSet<>();
    }

    /**
     * 사용자가 추측한 공 정보를 토대로 알맞은 결과를 {@link Result}의 형태로 리턴하는 메서드.
     *
     * @param guess 사용자가 추측한 공 정보
     * @return 추측한 공 정보와 현재 선택된 공 정보를 토대로 계산된 결과
     * @throws IllegalArgumentException 사용자의 입력이 올바르지 않은 경우(숫자가 아닌 입력, 자릿수가 다른 입력, 중복 입력 등) 발생
     * @see #validate(String)
     */
    Result calculate(String guess) {
        validate(guess);

        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < TOTAL_BALL_CNT.getValue(); idx++) {
            int current = balls[idx];
            int guessIdx = guess.indexOf(current + '0');
            if (guessIdx == idx) {
                strike += 1;
            } else if (guessIdx >= 0) {
                ball += 1;
            }
        }

        return new Result(strike, ball);
    }

    /**
     * 서로 다른 무작위의 세 공을 생성하는 메서드.
     *
     * @see Randoms#pickNumberInRange(int, int)
     * @see #isUniqueBall(int[], int, int)
     */
    private int[] generate() {
        int[] ball = new int[TOTAL_BALL_CNT.getValue()];

        int ballIdx = 0;

        while (ballIdx < TOTAL_BALL_CNT.getValue()) {
            int num = Randoms.pickNumberInRange(MIN_BALL_NUM.getValue(), MAX_BALL_NUM.getValue());
            if (isUniqueBall(ball, num, ballIdx)) {
                ball[ballIdx++] = num;
            }
        }

        return ball;
    }

    /**
     * 주어진 숫자가 이미 선택된 공들과 중복되지 않는 유일한 숫자인지 확인하는 메서드.
     *
     * @param ball    공 배열
     * @param num     주어진 숫자
     * @param lastIdx 현재까지 선택된 공의 인덱스
     * @return 유일한 공 번호라면 true, 유일하지 않다면 false
     * @see #generate()
     */
    private boolean isUniqueBall(int[] ball, int num, int lastIdx) {
        for (int idx = 0; idx < lastIdx; idx++) {
            if (ball[idx] == num) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자의 공 정보 입력이 올바른 형태인지 체크하는 메서드.
     *
     * @param input 사용자의 입력
     * @throws IllegalArgumentException 사용자의 입력이 올바르지 않은 경우(숫자가 아닌 입력, 자릿수가 다른 입력, 중복 입력 등) 발생
     * @see baseball.constant.ExceptionMessage
     * @see #isNotBall(char)
     */
    private void validate(String input) {
        if (input.length() != TOTAL_BALL_CNT.getValue()) {
            throw new IllegalArgumentException(LENGTH.build(input.length()));
        }

        validation.clear();

        for (char ch : input.toCharArray()) {
            if (validation.contains(ch)) {
                throw new IllegalArgumentException(DUPLICATE.build(input));
            }
            if (isNotBall(ch)) {
                throw new IllegalArgumentException(NUMBER.build(input));
            }
            validation.add(ch);
        }
    }

    /**
     * 주어진 글자가 공과 관련된 문자인지 확인하는 메서드.
     *
     * @param ch 주어진 글자
     * @return 공이 아니라면 false, 공이라면 true
     * @see #validate(String)
     */
    private boolean isNotBall(char ch) {
        int num = ch - '0';

        return num < MIN_BALL_NUM.getValue() || num > MAX_BALL_NUM.getValue();
    }
}
