package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        List<Integer> computer = getRandomList();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getRandomList() {
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
