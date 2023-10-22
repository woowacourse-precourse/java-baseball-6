package baseball.makerandomnumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class threerandommaker implements Randomgenerator{
    final public int digit = 3;
    @Override
    public List<Integer> getRandom() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < digit){
            int num = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(num)){
                computer.add(num);
            }
        }
        return computer;
    }
}
