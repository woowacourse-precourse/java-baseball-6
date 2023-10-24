package baseball.Model;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    //랜덤 숫자 생성하기
    public void createRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

}
