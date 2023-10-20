package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 세 자리 수 만들기

        // computer : 랜덤으로 생성한 세 자리 수를 저장할 list
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1,9) + 1;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 하나의 수를 고르는 방법.
        // pickNumberInRange(1,9) => 9 - 1 + 1 => 0~8 사이의 랜덤 수를 고름
        // (0~8) + 1 => (1~9)

        

    }
}
