package baseball.Controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumbersGenerator {

    public ArrayList<Integer> generateNumbers() {
        ArrayList<Integer> computernumbers = new ArrayList<>();
        while (computernumbers.size() < 3) {
            int randomnumber = Randoms.pickNumberInRange(1, 9);
                if (!computernumbers.contains(randomnumber))
                     computernumbers.add(randomnumber);
                }
        return computernumbers;
    }

}
