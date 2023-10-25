package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GetRandomNum {
    static final int ARRAY_SIZE = 3;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    public List<Integer> create(){
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < ARRAY_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM); // 1~9 사이 랜덤 값 가져오기
            if(computerNumber.contains(randomNumber)){ // 중복 막기
                continue;
            } else {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

}