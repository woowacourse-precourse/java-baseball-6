package baseball.model;

import static baseball.constant.ExceptionMessage.INPUT_NO_OPTION_EXCEPTION_MESSAGE;

import java.util.Objects;

public enum EndOption {
    NEXT_ROUND(1),
    END(2);

    private int numOption;

    EndOption(int numOption) {
        this.numOption = numOption;
    }

    public static EndOption findBySelection(String selection) {
        for (EndOption option : EndOption.values()) {
            if (Objects.equals(option.numOption, Integer.parseInt(selection))) {
                return option;
            }
        }

        throw new IllegalArgumentException(INPUT_NO_OPTION_EXCEPTION_MESSAGE);
    }
}
