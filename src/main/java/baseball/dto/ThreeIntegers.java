package baseball.dto;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ThreeIntegers {
    List<Integer> integers;

    private ThreeIntegers() {
    }

    public ThreeIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public static ThreeIntegers createRandomThreeIntegers() {
        List<Integer> pickedIntegers = new ArrayList<>();
        while (pickedIntegers.size() < 3) {
            int pickedInteger = pickNumberInRange(1, 9);
            if (!pickedIntegers.contains(pickedInteger)) {
                pickedIntegers.add(pickedInteger);
            }
        }
        return new ThreeIntegers(pickedIntegers);
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public Score calculateScoreFrom(String inputValue) {
        Score score = Score.builder().build();

        for (int i = 0; i < inputValue.length(); i++) {
            for (int j = 0; j < this.integers.size(); j++) {
                if (inputValue.charAt(i) == this.integers.get(j).toString().charAt(0) && i == j) {
                    score.increaseStrikeCount();
                    break;
                }

                if (inputValue.charAt(i) == this.integers.get(j).toString().charAt(0)) {
                    score.increaseBallCount();
                }
            }
        }
        return score;
    }
}
