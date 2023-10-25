package baseball.model;

import baseball.constant.Rule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {

    private List<Integer> randomNum;
    public Computer() {}

    public List<Integer> createRandomNum(){
        randomNum = new ArrayList<>();

        while (randomNum.size() < Rule.MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Rule.START_NUM, Rule.END_NUM);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }

        return randomNum;
    }

}
