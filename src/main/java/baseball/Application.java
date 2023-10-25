package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    // 임의의 수 3가지 부여 기능
    static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
    public static void main(String[] args) {

        // 임의의 수 3가지
        List<Integer> randomNumbers;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 임의의 수 3가지 부여
        randomNumbers = getRandomNumbers();
    }
}
