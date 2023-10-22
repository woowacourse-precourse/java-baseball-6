package baseball.game;

import static baseball.constant.GameConstant.NONE;
import static baseball.constant.GameConstant.THREE_STRIKE;
import static baseball.constant.Message.BALL;
import static baseball.constant.Message.NOTHING;
import static baseball.constant.Message.STRIKE;

/**
 * {@summary 게임의 결과를 다룬다.}
 * <p>
 * Result 클래스는 게임의 결과를 다루기 위한 클래스이다. 한번 정해진 결과는 변경될 수 없기에 멤버 변수는 모두 final로 선언된다. 결과가 생성될 때 결과에 따라 출력될 메세지가 결정되고, 이는
 * {@link Result#toString()}메서드를 통해 반환받는다.
 */
class Result {
    /**
     * 스트라이크의 개수
     */
    private final int strike;
    /**
     * 볼의 개수
     */
    private final int ball;
    /**
     * 스트라이크와 볼의 개수에 따라 설정할 메세지
     */
    private final StringBuilder message;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        this.message = new StringBuilder();
        setMessage();
    }

    /**
     * 게임의 결과가 낫싱(0볼 0스트라이크)임을 판단하기 위한 메서드.
     *
     * @return 볼과 스트라이크 모두 0개라면 true, 하나라도 0개가 아니라면 false
     */
    private boolean isNothing() {
        return ball == NONE.getValue() && strike == NONE.getValue();
    }

    /**
     * 볼과 스트라이크의 개수에 따라 메세지를 설정하는 메서드.
     */
    private void setMessage() {
        if (isNothing()) {
            message.append(NOTHING.getValue());
            return;
        }

        if (ball > NONE.getValue()) {
            message.append(ball).append(BALL.getValue());
            if (strike > NONE.getValue()) {
                message.append(" ");
            }
        }

        if (strike > NONE.getValue()) {
            message.append(strike).append(STRIKE.getValue());
        }
    }

    /**
     * 게임의 결과가 승리(3스트라이크)인지를 판단하기 위한 메서드.
     *
     * @return 3스트라이크라면 true, 3스트라이크가 아니라면 false
     */
    public boolean isWin() {
        return strike == THREE_STRIKE.getValue();
    }

    @Override
    public String toString() {
        return message.toString();
    }
}
