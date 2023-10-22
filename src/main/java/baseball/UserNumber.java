package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private List<Integer> userNumber = new ArrayList<>();

    public UserNumber() {
        this.userNumber = getUserNumber();
    }

    private List<Integer> getUserNumber() {

        String inputNumber = Console.readLine();

        // 자릿수가 3인지 확인
        sizeValidator(inputNumber);

        // 숫자로 정상 변경이 되는지 확인
        formatValidator(userNumber, inputNumber);

        //  중복 제거 후 자릿수가 3인지 확인
        duplicationValidator(userNumber);

        return userNumber;
    }

    private void duplicationValidator(List<Integer> userNumber) {
        if (userNumber.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private void formatValidator(List<Integer> userNumber, String inputNumber) {
        try {
            for (int i = 0; i < 3; i++) {
                userNumber.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private void sizeValidator(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }
}
