package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Stream;

public class CreatingAnswer {

    /*
    1️⃣ 정답을 만드는 기능
    - 상대방 (컴퓨터) 의 3자리 수를 랜덤하게 생성한다.
    */

    private int random_number;

    public CreatingAnswer() {
    }

    public int getRandomNumber() {
        while (true) {
            random_number = Randoms.pickNumberInRange(111, 999);  // 랜덤 정수 추출
            if (isValidateNumber(random_number)) {
                return random_number;
            }
        }
    }

    private boolean isValidateNumber(int number) {              // 각 자리 숫자 다른지 검사
        int first_num = random_number / 100;
        int second_num = (random_number % 100) / 10;
        int third_num = (random_number % 100) % 10;
        if (first_num != second_num && second_num != third_num && first_num != third_num) {
            return true;
        } else {
            return false;
        }
    }
}
