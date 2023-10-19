package baseball.Randomgenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ranomgenerator implements Randomgenerator{
    @Override
    public String getRandom() {
        List<Integer> randomValue = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        String value = "";
        for(Integer e : randomValue){
            value += Integer.toString(e);
        }
        return value;
    }
}
