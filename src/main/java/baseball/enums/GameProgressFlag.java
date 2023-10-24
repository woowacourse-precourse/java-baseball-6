package baseball.enums;

/**
 * 게임 진행을 어떻게 할지 대한 flag
 */
public enum GameProgressFlag {

    RESTART("1"), // 게임 재시작
    END("2") // 종료
    ;

    private String flagValue;

    GameProgressFlag(String flagValue) {
        this.flagValue = flagValue;
    }

    public String getFlagValue() {
        return flagValue;
    }

}
