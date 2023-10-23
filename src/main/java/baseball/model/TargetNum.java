package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TargetNum {

    public final static int targetLength = 3;
    private final static int[] target = new int[targetLength];
    private final static List<Integer> numbers = new ArrayList<>();

    public TargetNum(){
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        makeTarget();
    }

    private void  makeTarget(){
        for (int i = 0; i < targetLength; i++) {
            target[i] = getRandom();
            numbers.remove(Integer.valueOf(target[i]));
        }
    }

    private int getRandom(){
        return Randoms.pickNumberInList(numbers);
    }

    public int[] getTarget(){
        return target;
    }
}


