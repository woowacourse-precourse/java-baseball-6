package baseballgame;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseballgame.Constant.*;


public class Play {
    List<Integer> result = new ArrayList<>();

    public Play(){
        // 컴퓨터의 숫자 생성하고 list에 집어넣기
        while(result.size() < ANSWER_SIZE ){
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if(!result.contains(randomNumber)){
                result.add(randomNumber);
            }
        }
    }
}
