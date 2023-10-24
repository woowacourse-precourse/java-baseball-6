package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* 1에서 9까지 서로 다른 임의의 수 3개의 숫자 생성 */
public class BaseballComputer {
    // HashSet<Integer> 타입을 String 타입으로 변환 (숫자 게임에 사용)
    public String createComputerNumber() {
        HashSet<Integer> numbers = pickRandomNumbers();
        StringBuilder str = new StringBuilder();
        for (Integer computerNumber : numbers) {
            str.append(computerNumber);
        }
        return str.toString();
    }

    // 랜덤으로 1~9 사이의 임의의 숫자 생성 (중복 x)
    private HashSet<Integer> pickRandomNumbers() {
        HashSet<Integer> picks = new LinkedHashSet<>(); // 중복 방지용 hashset
        while (picks.size() < 3) {
            picks.add(Randoms.pickNumberInRange(1, 9));
        }
        return picks;
    }
}