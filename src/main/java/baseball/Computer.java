package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number = new ArrayList<>();
    private String result;

    public List<Integer> getNumber() {
        return number;
    }

    public void setRandomNumber() {
        resetNumber();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void printResult() {
        System.out.println(result);
    }

    private void resetNumber() {
        number.clear();
    }
}
