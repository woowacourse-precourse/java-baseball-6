package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class computer {
    private final List<Integer> numbers = new ArrayList<>(); // 컴퓨터가 생성한 숫자 리스트

    private void threeRandomsNum() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            add(randomNumber);
        }
    }

    private void add(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
