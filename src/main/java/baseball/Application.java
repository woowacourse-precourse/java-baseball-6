package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    private static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(random)) {
                randomNumbers.add(random);
            }
        }
        return randomNumbers;
    }
}
