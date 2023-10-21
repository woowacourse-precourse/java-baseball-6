package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    // 컴퓨터 랜덤 점수
    public static ArrayList<Integer> randomNumber() {

        ArrayList<Integer> randomNum = new ArrayList<>();

        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        return randomNum;
    }
}
