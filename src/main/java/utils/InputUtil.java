package utils;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import validation.Validation;

public class InputUtil {
    // 검증 객체
    private static final Validation validation = new Validation();

    public static List<Integer> getPlayerInput() {
        try {
            String playerInput = Console.readLine();

            // 사용자 인풋 검증
            validation.validatePlayerInput(playerInput);

            // 사용자 인풋 List로 변경하여 반환
            return strToList(playerInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PLAYER_INPUT_LENGTH.getMessage());
        }
    }

    public static Integer getRestartInfo() {
        try {
            String restartInfo = Console.readLine();

            // 재시작 정보 검증
            validation.validateRestartInfo(restartInfo);

            // 재시작 정보 정수값으로 변환하여 반환
            return Integer.parseInt(restartInfo);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_INFO_LENGTH.getMessage());
        }
    }

    private static List<Integer> strToList(String playerInput) {
        List<Integer> listPlayerInput = new ArrayList<>();
        for (int idx = 0; idx < playerInput.length(); idx++) {
            listPlayerInput.add(Integer.parseInt(String.valueOf(playerInput.charAt(idx))));
        }

        return listPlayerInput;
    }
}
