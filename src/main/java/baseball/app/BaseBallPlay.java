package baseball.app;

import baseball.domain.Ball;
import baseball.domain.ComNums;
import baseball.domain.Strike;
import baseball.domain.UserNums;

public class BaseBallPlay {
    private final String ENTER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static Strike strike;
    private static Ball ball;
    private static UserNums userNums;
    private static ComNums comNums;

    public int play() {
        init();
        strikeAndBall();
        return resultCheck();
    }

    public void init() {
        System.out.print(ENTER_INPUT_MESSAGE);
        this.strike = new Strike(0);
        this.ball = new Ball(0);
        createUserNums();
    }

    public int resultCheck() {
        if (ball.getCount() == 0 && strike.getCount() == 0) {
            System.out.println("낫싱");
        } else if (ball.getCount() == 0) {
            System.out.println(String.format("%d스트라이크", strike.getCount()));
        } else if (strike.getCount() == 0) {
            System.out.println(String.format("%d볼", ball.getCount()));
        } else if (ball.getCount() != 0 && strike.getCount() != 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ball.getCount(), strike.getCount()));
        }
        return strike.getCount();
    }

    public void strikeAndBall() {
        for (int i = 0; i < comNums.size(); i++) {
            if (userNums.contains(comNums.get(i)) && userNums.get(i) == comNums.get(i)) {
                strike.increase();
            } else if (userNums.contains(comNums.get(i)) && userNums.get(i) != comNums.get(i)) {
                ball.increase();
            }
        }
    }

    public static void createComNums() {
        comNums = new ComNums();
    }

    public void createUserNums() {
        userNums = new UserNums();
    }
}
