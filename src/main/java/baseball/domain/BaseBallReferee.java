package baseball.domain;

public class BaseBallReferee {

    public BaseballResult returnBaseballResult(BaseballNumber userNumbers, BaseballNumber computerNumbers) {
        BaseballResult baseballResult = new BaseballResult();
        boolean checkNothing = true;

        for (int userIdx = 0; userIdx < userNumbers.size(); userIdx++) {
            for (int computerIdx = 0; computerIdx < userNumbers.size(); computerIdx++) {
                if (isStrike(userNumbers, computerNumbers, userIdx, computerIdx)) {
                    baseballResult.incrementCount(BaseballResultState.STRIKE);
                    checkNothing = false;
                }

                if (isBall(userNumbers, computerNumbers, userIdx, computerIdx)) {
                    baseballResult.incrementCount(BaseballResultState.BALL);
                    checkNothing = false;
                }
            }
        }

        if (checkNothing) {
            baseballResult.incrementCount(BaseballResultState.NOTHING);
        }

        return baseballResult;
    }

    private boolean isStrike(BaseballNumber userNumbers, BaseballNumber computerNumbers, int userIdx, int computerIdx) {
        if (userNumbers.getBaseballNumber().get(userIdx) == computerNumbers.getBaseballNumber().get(computerIdx)) {
            return userIdx == computerIdx;
        }

        return false;
    }

    private boolean isBall(BaseballNumber userNumbers, BaseballNumber computerNumbers, int userIdx, int computerIdx) {
        if (userNumbers.getBaseballNumber().get(userIdx) == computerNumbers.getBaseballNumber().get(computerIdx)) {
            return userIdx != computerIdx;
        }

        return false;
    }
}
