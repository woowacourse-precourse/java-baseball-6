package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> number;
    public Computer(){
        number = new ArrayList<>();
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(){
         number = Randoms.pickUniqueNumbersInRange(1, 9, 3);

    }

}
