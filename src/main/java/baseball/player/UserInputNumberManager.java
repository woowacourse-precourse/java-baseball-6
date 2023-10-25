package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

import static baseball.enums.Message.INPUT_USERNUMBER_MESSAGE;
import static baseball.enums.NumberInfo.COUNT;

public class UserInputNumberManager implements UserNumberManager {
    private String userNumber;

    @Override
    public String getUserNumber() {
        System.out.print(INPUT_USERNUMBER_MESSAGE.getMessage());
        userNumber = Console.readLine();

        validInteger(userNumber);
        validDuplication(userNumber);
        validThreeDigit(userNumber);
        validZeroValue(userNumber);

        return userNumber;
    }

    public void validInteger(String Number) {
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                throw new IllegalArgumentException("[Error]: 각 자리는 정수값이어야 합니다.");
            }
        }
    }

    public void validDuplication(String Number) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            set.add(Number.charAt(i));
        }
        if (!(set.size() == COUNT.getNumberInfo())) {
            throw new IllegalArgumentException("[Error]: 중복된 숫자가 존재합니다.");
        }
    }

    public void validThreeDigit(String Number) {
        if (Number.length() != COUNT.getNumberInfo()) {
            throw new IllegalArgumentException("[Error]: 세 자리 정수값을 입력하세요.");
        }
    }

    public void validZeroValue(String Number) {
        for (int i = 0; i < Number.length(); i++) {
            if (Number.charAt(i) == '0') {
                throw new IllegalArgumentException("[Error]: 0은 들어갈 수 없습니다.");
            }
        }
    }
}