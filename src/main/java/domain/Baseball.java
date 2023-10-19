package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseball {

    private final List<Integer> baseNumber; // 랜덤번호 생성

    public Baseball() {
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3){
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
