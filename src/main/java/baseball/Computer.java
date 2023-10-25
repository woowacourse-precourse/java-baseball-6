package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    @Override
    public String toString() {
        return "Computer{" +
                "Number=" + Number +
                '}';
    }

    private List<Integer> Number = new ArrayList<>(3);

    // Constructor Set Random value
    public Computer() {
        this.setNumber();
    }

    // Set Random Number If New Game Start.
    public void setNumber() {

        // Reset Array For Random
        Number = Arrays.asList(0, 0, 0);

        // Generate Random Value
        for (int numberIdx = 0; numberIdx < 3; numberIdx++) {
            int randomNumber = 0;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (this.Number.contains(randomNumber));
            this.Number.set(numberIdx, randomNumber);
        }
    }


    public ReturnType Confirm(List<Integer> Human) {
        return null;
    }
}
