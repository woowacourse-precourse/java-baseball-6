package baseball.enums;

public enum Constant {

    BEGIN_NUMBER(1),
    END_NUMBER(9),
    MAX_NUMBER_LENGTH(3),
    GAME_RESTART_COMMAND(1),
    GAME_END_COMMAND(2),
    GAME_COMMAND_LENGTH(1);

    private int constant;

    // Private 생성자(싱글톤)
    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
