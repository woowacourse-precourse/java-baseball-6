package baseball.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Pick implements RandomUtil{
    private static final Pick instance = new Pick();

    private Pick(){

    }

    public static Pick getInstance(){
        return instance;
    }

    @Override
    public List<Integer> getBallNumber() {
        Set<Integer> set = new LinkedHashSet<>();
        while(set.size()<3){
            set.add(Randoms.pickNumberInRange(1,9));
        }

        return set.stream().toList();
    }
}
