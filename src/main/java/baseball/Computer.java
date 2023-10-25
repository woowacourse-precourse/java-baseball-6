package baseball;

import baseball.Global.Ball;
import baseball.Global.Strike;
import java.util.Iterator;
import java.util.List;

public class Computer {
    private NumberArray computerNum = new NumberArray();

    private void checkBallOrStrike(int num, int index) {
        Ball ball = Ball.getInstance();
        Strike strike = Strike.getInstance();
        int value = computerNum.getNumList().get(index);

        if (value == num) {
            strike.setNum(strike.getNum() + 1);
            return;
        }
        ball.setBallNum(ball.getBallNum() + 1);
    }

    private void checkIfExist(int num, int index) {
        if (computerNum.getNumList().contains(num)) {
            checkBallOrStrike(num, index);
        }
    }

    public void check(List<Integer> numList) {
        int i = 0;
        Iterator<Integer> iter = numList.iterator();
        while (iter.hasNext()) {
            checkIfExist(iter.next(), i);
            i++;
        }
    }

}
