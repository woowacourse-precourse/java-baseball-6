package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    // 숫자 랜덤으로 뽑기아서 리스트에 넣기
        List<Integer> createRandomNum() {

                List<Integer> radomNumList = new ArrayList<>();

                while (radomNumList.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!radomNumList.contains(randomNumber)) {
                            radomNumList.add(randomNumber);
                        }
                }
                return radomNumList;
        }
}
