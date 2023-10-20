package baseball.Randomgenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ranomgenerator implements Randomgenerator{

    final public int digit = 3;
    @Override
    public List<Integer> getRandom() {
        List<Integer> randomValue = new ArrayList<>();
        while(randomValue.size() != digit){
            int num = Randoms.pickNumberInRange(1, 9);
            if(randomValue.isEmpty()) {
                randomValue.add(num);
                continue;
            }
            if(!randomValue.contains(num)){
                randomValue.add(num);
            }
        }
        return randomValue;
    }
}
