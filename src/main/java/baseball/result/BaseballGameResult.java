package baseball.result;

/**
 * @author 민경수
 * @description ball count result
 * @since 2023.10.23
 **********************************************************************************************************************/
public class BaseballGameResult {

    private Integer strikeCount;
    private Integer ballCount;
    private Boolean end;

    public BaseballGameResult(Integer strikeCount, Integer ballCount, boolean end) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.end = end;
    }

    public Integer strikeCount() {
        return this.strikeCount;
    }

    public Integer ballCount() {
        return this.ballCount;
    }

    public Boolean isEnd() {
        return this.end;
    }

}