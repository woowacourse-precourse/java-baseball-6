package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateNumbers {

    public static List<Integer> makeRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();

        // 중복 값 제거를 하기 위해서 랜덤 추출된 값을 Set에 넣음
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            NumberSet.add(randomNumber);
        }
        List<Integer> computerList = new ArrayList<>(NumberSet);

        return computerList;
    }
}
