package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class ComputerNum {
    private final int START_RANGE = 1;
    private final int END_RANGE = 9;
    private final int LIST_LENGTH = 3;
    private List<Integer> compNum = new ArrayList<>();
    public ComputerNum(){
        this.compNum = createRandomNum();
    }

    public List<Integer> createRandomNum(){
        List<Integer> list =
                Arrays
                .stream(new List[LIST_LENGTH])
                .map(aNumber -> Randoms.pickNumberInRange(START_RANGE, END_RANGE))
                .collect(Collectors.toList());
        if(list.stream().distinct().count() == 3){
            return list;
        }
        return createRandomNum();
    }

    public List<Integer> getComputerNum(){
        return compNum;
    }
}
