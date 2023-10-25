package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public record BaseballNumber(int value) {
    public static int START_NUMBER = 1;
    public static int END_NUMBER = 9;
    public BaseballNumber {
        if (value < START_NUMBER || END_NUMBER < value) {
            throw new IllegalArgumentException("야구 게임 숫자 범위는 " + START_NUMBER + "부터 " + END_NUMBER + "까지입니다.");
        }
    }

    public static BaseballNumber createRandomNumber() {
        return new BaseballNumber(pickNumberInRange(BaseballNumber.START_NUMBER, BaseballNumber.END_NUMBER));
    }
}
