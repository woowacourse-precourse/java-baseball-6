package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int randomNumber;
    private int min;
    private int max;

    public RandomNumber(int min, int max) {
        this.min = min;
        this.max = max;
        validateMinMax(min, max);
        validateRange(min, max);
        this.randomNumber = Randoms.pickNumberInRange(min, max);
    }

    private void validateMinMax(int min, int max) {
        if (min > max) {
            int box = max;
            this.max = min;
            this.min = box;
        }
    }

    private void validateRange(int min, int max) {
        if (!(1 <= min && min <= 9 || 1 <= max && max <= 9)) {
            throw new RuntimeException(" 1부터 9사이 숫자를 입력해주세요.");
        }
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
