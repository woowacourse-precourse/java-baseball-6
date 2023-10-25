package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public final List<Character> numbers = new ArrayList<>(); // 컴퓨터가 생성한 숫자 리스트

    public void threeRandomsNum() {
        numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            add(randomNumber);
        }
    }

    public void add(int randomNumber) {
        char num = (char) (randomNumber + 48);
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }
}
