package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    /** 컴퓨터의 숫자를 저장 */
    private List<Integer> numberList = new ArrayList<>();
    public void init() {
        numberList.clear();
        while(numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }

    /**
     * 스트라이크, 볼 판정
     * @param input: user가 입력한 숫자 리스트
     * @return 스트라이크, 볼을 표기한 Map
     */
    public Map<String, Integer> compare(List<Integer> input) {
        Map<String, Integer> result = new HashMap<>();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if(numberList.get(i) == input.get(i)) {
                strike++;
            }
            else if(numberList.contains(input.get(i))) {
                ball++;
            }
        }

        result.put("strike", strike);
        result.put("ball", ball);
        return result;
    }
}