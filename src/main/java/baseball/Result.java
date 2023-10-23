package baseball;

public class Result {

    private final Baseballs computerNumbers;
    private final Baseballs userNumbers;

    public Result(final Baseballs computerNumbers, final Baseballs userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    public GameResult getGameResult() {
        BaseballCompareResult compareResult = userNumbers.compare(computerNumbers);
        return GameResult.valueOf(compareResult.getBall(), compareResult.getStrike());
    }
}
