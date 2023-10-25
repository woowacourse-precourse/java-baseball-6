package constant;

public enum Constant {
    ZERO(0),
    INITIAL_VALUE(0),
    BASEBALL_GAME_NUMBER_LENGTH(3),
    BASEBALL_GAME_NUMBER_RANGE_START_VALUE(1),
    BASEBALL_GAME_NUMBER_RANGE_LAST_VALUE(9),
    RESTART_INFO_LENGTH(1),
    RESTART_VALUE(1),
    FINISH_GAME_VALUE(2),
    NO_EXIST_VALUE(0);

    private Integer value;

    private Constant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
