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
    public UserNum(String inputNum){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<inputNum.length();i++){
            list.add(inputNum.charAt(i)-'0');
        }

        this.userNum = list;
    }

    public List<Integer> getUserNum(){
        return userNum;
    }
}
