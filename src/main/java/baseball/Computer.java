package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setRandomNumber() {
        this.numbers = makeRandomNum();
    }

    private static List<Integer> makeRandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { // 서로 다른 숫자들로만 구성하게하는 부분.
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
