package utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import validation.Validation;

public class InputUtil {
    // 검증 객체
    private static final Validation validation = new Validation();

    public static List<Integer> getPlayerInput() {
        String playerInput = Console.readLine();

        // 사용자 인풋 검증
        validation.validatePlayerInput(playerInput);

        // 사용자 인풋 List로 변경하여 반환
        return strToList(playerInput);
    }

    private static List<Integer> strToList(String playerInput) {
        List<Integer> listPlayerInput = new ArrayList<>();
        for (int idx = 0; idx < playerInput.length(); idx++) {
            listPlayerInput.add(Integer.parseInt(String.valueOf(playerInput.charAt(idx))));
        }

        return listPlayerInput;
    }
}
