package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import static constant.BaseConst.*;

public class Baseball {

    private final List<Integer> baseNumber; // 랜덤번호 생성

    public Baseball() {
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < MAX_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)){
                temp.add(randomNumber);
            }
        }
        this.baseNumber = temp;
    }

    public List<Integer> getBaseNumber() {
        return baseNumber;
    }
}
