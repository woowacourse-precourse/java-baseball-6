package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    //리스트에 저장되는 숫자 사이즈
    private static final int NUM_LEN = 3;
    //각 자릿수의 숫자 중 될 수 있는 가장 작은 숫자
    private static final int MIN_NUM = 1;
    //각 자릿수의 숫자 중 될 수 있는 가장 큰 숫자
    private static final int MAX_NUM = 9;

    //리스트에 랜덤한 중복되지 않은 숫자를 저장한 후 리스트 반환
    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_LEN) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}