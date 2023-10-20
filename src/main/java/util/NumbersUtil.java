package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class NumbersUtil {

    private final ArrayList<Integer> numbers;

    private boolean gameSet;

    public NumbersUtil() {
        numbers = new ArrayList<>();
    }

    public void clear() {
        gameSet = false;
        numbers.clear();
    }

    public void setNumbers() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
    public int[] ballCount(int[] numbers) {
        int[] ballStrike = new int[2];
        for(int i = 0; i < 3; i++) {
            if(this.numbers.get(i) == numbers[i]) {
                ballStrike[1]++;
            }else if(this.numbers.contains(numbers[i])) {
                ballStrike[0]++;
            }
        }
        if(ballStrike[1] == 3) { gameSet = true; }
        return ballStrike;
    }

    public boolean getGameSet() { return gameSet; }
}
