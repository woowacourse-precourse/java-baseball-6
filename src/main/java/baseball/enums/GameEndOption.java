package baseball.enums;

public enum GameEndOption {
    RESTART("1"),
    END("2");

    private final String option;

    GameEndOption(String option) {
        this.option = option;
    }

    public String getOptionValue() {
        return option;
    }

    public static GameEndOption fromString(String optionValue) {
        for (GameEndOption option : GameEndOption.values()) {
            if (option.getOptionValue().equals(optionValue)) {
                return option;
            }
        }
        throw new IllegalArgumentException(ErrorCode.INVALID_GAME_END_OPTION.getMessage());
    }
}
