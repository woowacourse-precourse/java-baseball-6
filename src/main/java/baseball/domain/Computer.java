package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    String number;

    public Computer() {
        this.number = generateRandomNumber();
    }

    public String getNumber() {
        return number;
    }

    private String generateRandomNumber() {
        Set<Integer> chosenDigits = new HashSet<>();

        int firstDigit = Randoms.pickNumberInRange(1, 9);  // 첫 번째 자리는 0이 올 수 없으므로 1~9 사이의 숫자를 선택합니다.
        chosenDigits.add(firstDigit);

        int secondDigit;
        do {
            secondDigit = Randoms.pickNumberInRange(0, 9);
        } while (chosenDigits.contains(secondDigit));  // 이미 선택된 숫자가 아닐 때까지 반복
        chosenDigits.add(secondDigit);

        int thirdDigit;
        do {
            thirdDigit = Randoms.pickNumberInRange(0, 9);
        } while (chosenDigits.contains(thirdDigit));  // 이미 선택된 숫자가 아닐 때까지 반복

        return String.valueOf(firstDigit) + String.valueOf(secondDigit) + String.valueOf(thirdDigit);
    }
}
