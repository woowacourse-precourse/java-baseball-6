package baseball.Model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {

    private final Numbers computerNums;
    private int strike;
    private int ball;
    private final List<Integer> randomNums;

    public Computer() {
        randomNums = generateRandomNums();
        computerNums = new Numbers(randomNums);
    }

    public List<Result> compare(Numbers playerNums) {
        List<Result> results = Judge.compareNumbers(this.computerNums.getValues(), playerNums.getValues());
        calculateCnt(results);
        return results;
    }

    public List<Integer> generateRandomNums() {
        List<Integer> randNums = new ArrayList<>();
        while (randNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNums.contains(randomNumber)) {
                randNums.add(randomNumber);
            }
        }
        return randNums;
    }

    private void calculateCnt(List<Result> results) {
        this.strike = (int) results.stream()
                .filter(comparisonResult -> comparisonResult == Result.STRIKE)
                .count();

        this.ball = (int) results.stream()
                .filter(comparisonResult -> comparisonResult == Result.BALL)
                .count();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}


