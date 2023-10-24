package baseball.numGame;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumsGenerator {
    private Integer minOfRange;
    private Integer maxOfRange;
    private Integer numOfNums;

    public RandomNumsGenerator(Integer minOfRange, Integer maxOfRange, Integer numOfNums) {
        this.minOfRange = minOfRange;
        this.maxOfRange = maxOfRange;
        this.numOfNums = numOfNums;
    }

    public List<Integer> generate() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < numOfNums) {
            int randomNum = Randoms.pickNumberInRange(minOfRange, maxOfRange);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }
        return randomNums;
    }


}
