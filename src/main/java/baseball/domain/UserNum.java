package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNum {
    private final int START_RANGE = 1;
    private final int END_RANGE = 9;
    private final int LIST_LENGTH = 3;
    private List<Integer> userNum = new ArrayList<>();
    public UserNum(){
        this.userNum = createRandomNum();
    }

    public List<Integer> createRandomNum(){
        return Arrays
                .stream(new List[LIST_LENGTH])
                .map(aNumber -> Randoms.pickNumberInRange(START_RANGE, END_RANGE))
                .collect(Collectors.toList());
    }

    public List<Integer> getUserNum(){
        return userNum;
    }
}
