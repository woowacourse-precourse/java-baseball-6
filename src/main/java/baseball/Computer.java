package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private List<Integer> numbers ;
    public Computer(){
        numbers = new ArrayList<>();
    }
    public void generateNumbers() {
        while (numbers.size() < BASEBALL_GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        System.out.println(getNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
