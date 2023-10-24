package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    public List<Integer> getComputerNum() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            computer.add(Randoms.pickNumberInRange(1, 9));
        }
        List<Integer> computerList = new ArrayList<>(computer);

        return computerList;
    }
}
