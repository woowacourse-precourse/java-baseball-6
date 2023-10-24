package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Production {
    List<Integer> comList = new ArrayList<>();
    // 3개의 랜덤 정수를 리스트에 추가
    public List<Integer> setComList(){
        comList.clear();
        while (comList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comList.contains(randomNumber)) {
                comList.add(randomNumber);
            }
        }
        return comList;
    }


}
