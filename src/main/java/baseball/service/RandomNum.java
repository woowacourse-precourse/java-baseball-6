package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private final static int startInclusive = 1;
    private final static int endInclusive = 9;
    private final static int count = 3;

    List<Integer> num = new ArrayList<>();

    public List<Integer> generateNum(){
        num = Randoms.pickUniqueNumbersInRange(startInclusive,endInclusive,count);
        return num;
    }
}
