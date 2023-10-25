package baseball;

import java.util.List;

public class JudgeMachine {
    private BaseballForm result;
    private List<Integer> targetNumbers;
    private List<Integer> userNumbers;
    private Integer numberOfNumbers;

    public BaseballForm judge(List<Integer> targetNumbers, List<Integer> userNumbers, Integer numberOfNumbers) {
        this.targetNumbers = targetNumbers;
        this.userNumbers = userNumbers;
        this.numberOfNumbers = numberOfNumbers;

        Integer numberOfStrikes = countStrike();
        Integer numberOfBalls = countBall(numberOfStrikes);
        Boolean isNothing = isNothing(numberOfStrikes, numberOfBalls);
        Boolean isCorrect = isCorrect(numberOfStrikes);

        result = new BaseballForm(numberOfStrikes, numberOfBalls, isNothing, isCorrect);
        return result;
    }


    private Integer countStrike() {
        int numberOfStrikes = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (targetNumbers.get(i).equals(userNumbers.get(i))) {
                numberOfStrikes++;
            }
        }
        return numberOfStrikes;
    }

    private Integer countBall(Integer numberOfStrikes) {
        int numberOfBalls;
        int tmp = 0;
        for (Integer elem : userNumbers) {
            if (targetNumbers.contains(elem)) {
                tmp++;
            }
        }
        numberOfBalls = tmp - numberOfStrikes;
        return numberOfBalls;
    }

    private Boolean isCorrect(Integer numberOfStrikes) {
        return (numberOfStrikes.equals(numberOfNumbers));
    }

    private Boolean isNothing(Integer numberOfStrikes, Integer numberOfBalls) {
        return (numberOfStrikes.equals(0) && numberOfBalls.equals(0));
    }
}
