package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public int[] computerCreateNumber() {
        NumberBaseball baseball = new NumberBaseball();
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int tempNum;
            do {
                tempNum = Randoms.pickNumberInRange(1, 9);
            } while (baseball.containsNumber(numbers, tempNum));
            numbers[i] = tempNum;
        }
        return numbers;
    }
}
