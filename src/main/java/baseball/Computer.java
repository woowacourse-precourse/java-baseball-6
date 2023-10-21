package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] answer = new int[3];

    Computer() {

    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }

    public void makeAnswer() {
        for (int i = 0; i < 3; i++) {
            selectNum(i);
        }
    }

    private void selectNum(int cnt) {
        int num;

        while (true) {
            num = Randoms.pickNumberInRange(0, 9);
            if (isRightNum(num, cnt))
                break;
        }

        answer[cnt] = num;
    }

    private boolean isRightNum(int num, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (answer[i] == num)
                return false;
        }
        return true;
    }

    public void makeResult() {

    }
}
