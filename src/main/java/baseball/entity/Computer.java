package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static List<Integer> number;
    public Computer(){
        setNumber();
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(){
        Set<Integer> tmp = new HashSet<>();
        while(tmp.size() < 3) {
            tmp.add(Randoms.pickNumberInRange(1, 9));
        }
        number =  new ArrayList<>(tmp);
    }

}
