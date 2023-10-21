package baseball;

import java.util.Iterator;
import java.util.List;

public class Computer {
    private NumberArray computerNum = new NumberArray();

    public Computer() {

    }

    private void checkBallorStrike(int num, int index) {
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
        System.out.println(num);
        if (computerNum.getNumList().contains(num)) {
            checkBallorStrike(num, index);
        }
    }

    public void check(List<Integer> numList) {
        int i = 0;
        Iterator<Integer> iter = numList.iterator();
        while (iter.hasNext()) {
//            System.out.println(iter.next() + "");
            checkIfExist(iter.next(), i);
            i++;
        }
    }

}
