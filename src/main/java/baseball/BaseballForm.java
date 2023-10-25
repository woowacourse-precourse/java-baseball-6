package baseball;

public class BaseballForm {
    private Integer numberOfBalls;
    private Integer numberOfStrikes;
    private Boolean isNothing;
    private Boolean isCorrect;

    public BaseballForm() {
        numberOfStrikes = 0;
        numberOfBalls = 0;
        isNothing = false;
        isCorrect = false;
    }

    public BaseballForm(Integer numberOfStrikes, Integer numberOfBalls, Boolean isNothing, Boolean isCorrect) {
        this.numberOfStrikes = numberOfStrikes;
        this.numberOfBalls = numberOfBalls;
        this.isNothing = isNothing;
        this.isCorrect = isCorrect;
    }

    public Integer getNumberOfBalls() {
        return numberOfBalls;
    }

    public Integer getNumberOfStrikes() {
        return numberOfStrikes;
    }

    public Boolean getNothing() {
        return isNothing;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }
}
