package baseball;

import java.util.Objects;

public enum RestartType {
    RESTART(1),
    EXIT(2);

    private final int value;
    RestartType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RestartType findByValue(int value) {
        RestartType result = null;
        for (RestartType restartType : values()) {
            if (restartType.value == value) {
                result = restartType;
                break;
            }
        }
        return result;
    }

    public static boolean containsValue(int value) {
        if (Objects.isNull(findByValue(value)))
            return false;
        return true;
    }


}
