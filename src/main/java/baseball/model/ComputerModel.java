package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerModel {

    public int[] computerNumbers;

    public ComputerModel() {
        computerNumbers = createComputerNumbers();
    }

    private static int[] createComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        int[] computerNumbers = new int[3];
        for(int i = 0; i < numbers.size(); i++){
            computerNumbers[i] = numbers.get(i);
        }
        return computerNumbers;
    }

}
