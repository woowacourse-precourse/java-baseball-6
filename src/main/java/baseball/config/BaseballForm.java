package baseball.config;

public class BaseballForm {
    private Integer ballCnt;
    private Integer strikeCnt;
    private Boolean isNothing;


    public BaseballForm(Integer ballCnt, Integer strikeCnt, Boolean isNothing){
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
        this.isNothing = isNothing;
    }

}
