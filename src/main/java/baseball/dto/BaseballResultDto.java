package baseball.dto;

public class BaseballResultDto {
    private final int ballCnt;
    private final int strikeCnt;
    private final String messageFormat;

    public BaseballResultDto(int ballCnt, int strikeCnt, String messageFormat) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
        this.messageFormat = messageFormat;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
