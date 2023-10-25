package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String randomNumber;
    private static final int RANDOM_NUMBER_MAX_LENGTH = 3;

    // 1~9 사이의 랜덤한 임의의 숫자 3개를 선택하는 메서드.
    public void randomNumber() {
        String str = "";
        while (str.length() < RANDOM_NUMBER_MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!str.contains(String.valueOf(randomNumber))) {
                str += randomNumber;
            }
        }
        this.randomNumber = str;
    }

    // 선택한 임의의 숫자 3개를 리턴합니다.
    public String getRandomNumber() {
        return randomNumber;
    }
}