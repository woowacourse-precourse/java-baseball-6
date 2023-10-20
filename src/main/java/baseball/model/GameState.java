package baseball.model;

public class GameState {
    private static final String RESTART_FLAG = "1";
    private static final String END_FLAG = "2";
    private static final Integer MAXIMUM_NUMBER_LENGTH = 3;

    private boolean state; // 게임 상태 (진행 / 종료)
    private boolean success; // 컴퓨터의 숫자를 맞췄는지 여부

    public GameState() {
        this.state = true;
        this.success = false;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
}
