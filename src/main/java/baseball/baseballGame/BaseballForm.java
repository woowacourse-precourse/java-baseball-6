package baseball.baseballGame;

public class BaseballForm {
    private Integer ballCnt;
    private Integer strikeCnt;
    private Boolean isNothing;
    private Boolean isCorrect;

    public BaseballForm() {
        strikeCnt = 0;
        ballCnt = 0;
        isNothing = false;
        isCorrect = false;
    }

    public BaseballForm(Integer strikeCnt, Integer ballCnt, Boolean isNothing, Boolean isCorrect) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
        this.isNothing = isNothing;
        this.isCorrect = isCorrect;
    }

    public Integer getBallCnt() {
        return ballCnt;
    }

    public Integer getStrikeCnt() {
        return strikeCnt;
    }

    public Boolean getNothing() {
        return isNothing;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }
}
