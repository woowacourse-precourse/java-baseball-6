package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1. 선택
        List<Integer> selectNumber = new ArrayList<>();
        while (selectNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!selectNumber.contains(randomNumber)) {
                selectNumber.add(randomNumber);
            }
        }

    }
}
