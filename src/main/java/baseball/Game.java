package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> computerNum;

    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    public void validation(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
        }

        if (123 <= number && number <= 987) {
            int[] digits = new int[3];
            digits[0] = number % 10;
            digits[1] = (number / 10) % 10;
            digits[2] = number / 100;

            if (!(digits[0] != digits[1] && digits[1] != digits[2] && digits[0] != digits[2])) {
                throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
            }

        } else {
            throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
        }
    }
}
