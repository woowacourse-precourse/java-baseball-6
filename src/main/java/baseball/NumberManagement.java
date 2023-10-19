package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManagement {

    private int[] numbers;
    private boolean[] numberFlag;

    NumberManagement() {
        numbers = new int[3];
        numberFlag = new boolean[10];
    }

    public void close() {
        numbers = null;
        numberFlag = null;
    }

    public void makeNumbers(int idx) {
        if(idx == 3) { return; }
        int number = Randoms.pickNumberInRange(0, 8) + 1;
        if(numberFlag[number]) {
            makeNumbers(idx);
        } else {
            numberFlag[number] = true;
            numbers[idx] = number;
            makeNumbers(idx + 1);
        }
    }

    public void clear() {
        for(int i = 0; i < 3; i++) {
            numberFlag[numbers[i]] = false;
        }
    }

    public boolean numberCheck(int[] numbers) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if(this.numbers[i] == numbers[i]) {
                strike++;
            }else if(numberFlag[numbers[i]]) {
                ball++;
            }
        }
        printMessage(ball,strike);
        return strike == 3;
    }

    private void printMessage(int ball, int strike) {
        String message = "";
        if(ball > 0) {
            message += ball + "볼 ";
        }
        if(strike > 0) {
            message += strike + "스트라이크";
        }
        if(ball == 0 && strike == 0) {
            message = "낫싱";
        }
        System.out.println(message);
    }

}
