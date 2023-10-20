package util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumbersUtil {

    private final int[] numbers;
    private final boolean[] numberFlag;

    private boolean gameSet;

    public NumbersUtil() {
        numbers = new int[3];
        numberFlag = new boolean[10];
    }

    public void clear() {
        for(int i = 0; i < 3; i++) {
            numberFlag[numbers[i]] = false;
        }
    }

    public void setNumbers() {
        setNumbers(0);
    }

    private void setNumbers(int idx) {
        if(idx == 3) { return; }
        int number = Randoms.pickNumberInRange(0, 8) + 1;
        if(numberFlag[number]) {
            setNumbers(idx);
        } else {
            numberFlag[number] = true;
            numbers[idx] = number;
            setNumbers(idx + 1);
        }
    }

    public int[] ballCount(int[] numbers) {
        int[] ballStrike = new int[2];
        for(int i = 0; i < 3; i++) {
            if(this.numbers[i] == numbers[i]) {
                ballStrike[1]++;
            }else if(numberFlag[numbers[i]]) {
                ballStrike[0]++;
            }
        }
        if(ballStrike[1] == 3) { gameSet = true; }
        return ballStrike;
    }

    public boolean getGameSet() { return gameSet; }

}
