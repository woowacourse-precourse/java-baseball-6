package baseball.baseballV2.system.converter;

import baseball.baseballV2.model.RestartChoice;

public class StringToRestartChoiceConverter {
    public static final String RESTART_VALUE = "1";

    public static RestartChoice convert(String restartNumber) {
        if (isRestart(restartNumber)) {
            return RestartChoice.ONE;
        }
        return RestartChoice.TWO;
    }

    private static boolean isRestart(String restartNumber) {
        return restartNumber.equals(RESTART_VALUE);
    }
}
