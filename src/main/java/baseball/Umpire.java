package baseball;

public class Umpire {
    private final BaseballManager answerBaseballNumbers;
    private final BaseballManager inputBaseballNumbers;

    public Umpire(BaseballManager answerBaseballNumbers, BaseballManager inputBaseballNumbers) {
        this.answerBaseballNumbers = answerBaseballNumbers;
        this.inputBaseballNumbers = inputBaseballNumbers;
    }

    public boolean isCorrectNumber() {
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        return strikeCount == Constant.fixed_Number_Size;
    }

    public String getBaseballNumberCount() {
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        int ballCount = answerBaseballNumbers.getBall(inputBaseballNumbers);

        if (answerBaseballNumbers.isNothing(inputBaseballNumbers)) {
            return Constant.Status_None;
        }

        StringBuilder result = new StringBuilder();
        if (ballCount > 0) {
            result.append(ballCount).append(Constant.Status_Ball);
        }

        if (ballCount > 0 && strikeCount > 0) {
            result.append(" ");
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append(Constant.Status_Strike);
        }

        return result.toString();
        
    }
}
