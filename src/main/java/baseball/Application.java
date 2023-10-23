package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Application {
    public static void main(String[] args) {

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 랜덤 3자리의 수 생성
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }

    }
}
