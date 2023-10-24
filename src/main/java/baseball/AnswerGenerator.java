package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class AnswerGenerator {

    private static String itoa(int number){
        return Integer.toString(number);
    }

    public String generateAnswer() {
        List<String> computer = new ArrayList<String>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(this.itoa(randomNumber));
            }
        }
        return String.join("", computer);
    }

}