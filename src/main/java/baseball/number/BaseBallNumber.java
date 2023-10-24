package baseball.number;

public class BaseBallNumber {



    private boolean isStrike(int target)

    public boolean contains(BaseBallNumber compareBaseBallNumber){
        return userBaseballNumbers.stream()
                .anyMatch(baseBallNumber -> baseBallNumber.equals(compareBaseBallNumber));
    }
}
