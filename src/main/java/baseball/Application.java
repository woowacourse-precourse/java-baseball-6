package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 첫 콘솔 출력을 하는 시작 출력부
        // 2. 입력을 받는 입력부
        // 3. 입력을 검증하는 검증부
        // 4. 3의 결과를 출력해주는 입력검증 출력부
        // 5. 게임이 종료 되었을 때 출력을 해주는 게임 종료 출력부
        // 6. 게임을 다시 시작할지 여부를 확인하는 재시작 입력부


        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
