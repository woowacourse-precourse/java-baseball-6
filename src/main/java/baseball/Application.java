package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int DIGIT_COUNT = 3;


    public static void main(String[] args) {

    }


    // 무작위 숫자 리스트를 반환
    private static List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new ArrayList<>(computer);
    }


}
