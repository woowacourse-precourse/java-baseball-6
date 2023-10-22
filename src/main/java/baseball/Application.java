package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 컴퓨터 숫자 생성
        List<Integer> computer = createComputerNumberList();
    }

    /**
     * 컴퓨터가 3자리의 수를 만들 때 사용 됩니다.
     * @return 1부터 9까지 서로 다른 수 3개가 담긴 리스트
     */
    public static List<Integer> createComputerNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
