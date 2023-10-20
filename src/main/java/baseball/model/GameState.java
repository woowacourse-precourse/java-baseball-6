package baseball.model;

public class GameState {

    /* static */
    private static final String RESTART_FLAG = "1";
    private static final String END_FLAG = "2";
    private static final Integer MAXIMUM_NUMBER_LENGTH = 3;

    /* instance */
    private boolean state; // 게임 상태 (진행 / 종료)
    private boolean success; // 컴퓨터의 숫자를 맞췄는지 여부
    private Integer ballCount;
    private Integer strikeCount;

    public GameState() {
        this.state = true;
        this.success = false;
        initCount();
    }

    /* Getter */
    public boolean getSuccess() {
        return success;
    }

    public boolean getState() {
        return state;
    }

    public String getRestartFlag() {
        return RESTART_FLAG;
    }

    public String getEndFlag() {
        return END_FLAG;
    }

    public Integer getMaximumNumberLength() {
        return MAXIMUM_NUMBER_LENGTH;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    /* Setter */

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public void setState(boolean state) {
        this.state = state;
    }

    /* Usage functions */

    public void initCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void increaseBallCount() {
        ++this.ballCount;
    }

    public void increaseStrikeCount() {
        ++this.strikeCount;
    }
}
