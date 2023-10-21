package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> randomComputerNumber() { // 랜덤 숫자를 뽑는 메서드
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) { // 3자리 숫자를 뽑기 위함
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1부터 9까지의 랜덤 수

            if (!computer.contains(randomNumber)) { // 서로 같은 수의 중복을 피하기 위함
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
