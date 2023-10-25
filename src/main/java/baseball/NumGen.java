package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumGen {
    
    public static List<Integer> generate() {
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size() < 3) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(temp)) {
                list.add(temp);
            }
        }
        
        return list;
    }
    
}
