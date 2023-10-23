package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Production {
    //컴퓨터 패 생성
    public int[] settingArr(){
        List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        int[] comIntArray  = comList.stream().mapToInt(Integer::intValue).toArray();
        return comIntArray;
    }

}
