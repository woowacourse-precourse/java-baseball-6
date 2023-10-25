package validation;

import constant.Constant;
import constant.ErrorMessage;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public void validatePlayerInput(String playerInput) {
        validateNull(playerInput, ErrorMessage.INVALID_PLAYER_INPUT_LENGTH.getMessage());
        validateBlank(playerInput, ErrorMessage.INVALID_PLAYER_INPUT_LENGTH.getMessage());

        validateLength(playerInput, Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue(),
                ErrorMessage.INVALID_PLAYER_INPUT_LENGTH.getMessage());

        Set<Integer> setPlayerInptNmbr = new HashSet<>();
        for (int idx = 0; idx < Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue(); idx++) {
            validateDuplicationAndZero(playerInput.charAt(idx), setPlayerInptNmbr);
        }
    }

    public void validateRestartInfo(String restartInfo) {
        validateNull(restartInfo, ErrorMessage.INVALID_RESTART_INFO_LENGTH.getMessage());
        validateBlank(restartInfo, ErrorMessage.INVALID_RESTART_INFO_LENGTH.getMessage());

        validateLength(restartInfo, Constant.RESTART_INFO_LENGTH.getValue(),
                ErrorMessage.INVALID_RESTART_INFO_LENGTH.getMessage());

        validateDigit(restartInfo.charAt(0), ErrorMessage.INVALID_RESTART_INFO_TYPE.getMessage());

        validateCorrectRestartInfo(Integer.parseInt(restartInfo));
    }

    private void validateNull(String info, String errMsg) {
        if (info == null) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void validateBlank(String info, String errMsg) {
        if (info.isBlank()) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void validateLength(String info, int length, String errMsg) {
        if (info.length() != length) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void validateDigit(char info, String errMsg) {
        if (!Character.isDigit(info)) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    private void validateDuplicationAndZero(char chrNmb, Set<Integer> setPlayerInptNmbr) {
        validateDigit(chrNmb, ErrorMessage.INVALID_PLAYER_INPUT_TYPE.getMessage());

        int nmb = Integer.parseInt(String.valueOf(chrNmb));

        validateDuplicateNumber(nmb, setPlayerInptNmbr);

        validateZero(nmb);

        setPlayerInptNmbr.add(nmb);
    }

    private void validateZero(int nmb) {
        if (nmb == Constant.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PLAYER_INPUT_ZERO.getMessage());
        }
    }

    private void validateDuplicateNumber(int nmb, Set<Integer> setPlayerInptNmbr) {
        if (setPlayerInptNmbr.contains(nmb)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PLAYER_INPUT_DUPLICATION.getMessage());
        }
    }

    private void validateCorrectRestartInfo(int restartInfo) {
        if (restartInfo != Constant.RESTART_VALUE.getValue() && restartInfo != Constant.FINISH_GAME_VALUE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_INFO_VALUE.getMessage());
        }
    }
}
