package baseball;

public enum InputConstant {
    NEW_GAME(1), END_GAME(2), VALID_NUMBERS_LENGTH(3), VALID_END_INPUT_LENGTH(1);

    private final int num;

    InputConstant(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
