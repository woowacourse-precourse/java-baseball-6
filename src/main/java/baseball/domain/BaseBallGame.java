package baseball.domain;

public class BaseBallGame {

    private final BaseBallNumbers computerNumbers;
    private boolean isGameEnd;

    private BaseBallGame(boolean isGameEnd, BaseBallNumbers computerNumbers) {
        this.isGameEnd = isGameEnd;
        this.computerNumbers = computerNumbers;
    }

    public static BaseBallGame init(BaseBallNumbers computerNumbers) {
        System.out.println(computerNumbers);
        return new BaseBallGame(false, computerNumbers);
    }

    public BaseBallGameResult calculateResult(BaseBallNumbers playerNumbers) {
        BaseBallGameResult baseBallGameResult = computerNumbers.calculateResult(playerNumbers);
        isGameEnd = baseBallGameResult.isGameEnd();
        return baseBallGameResult;
    }

    public boolean isNotEnd() {
        return !isGameEnd;
    }

}
