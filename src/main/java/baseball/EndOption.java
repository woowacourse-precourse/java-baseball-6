package baseball;

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

        throw new IllegalArgumentException("1 또는 2만 입력이 가능합니다.");
    }
}
