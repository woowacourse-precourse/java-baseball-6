package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> playerNumber = new ArrayList<>();
    public static final String GAME_RESTART = "1";
    public static final String GAME_END = "2";

    public boolean inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputNumber = Console.readLine();
        // 만약 playerNumber가 비어있지 않으면 비워준다.
        if (!playerNumber.isEmpty()) {
            resetPlayerNumber();
        }

        try {
            Validation.validateInputNumber(playerInputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        for (String digits : playerInputNumber.split("")) {
            playerNumber.add(Integer.parseInt(digits));
        }
        return true;
    }

    public void resetPlayerNumber() {
        playerNumber.clear();
    }

    public static String gamePlayOrNot() {
        String selectNumber = Console.readLine();
        if (selectNumber.equals(GAME_RESTART)) {
            return GAME_RESTART;
        }
        if (selectNumber.equals(GAME_END)) {
            System.out.println("게임을 종료합니다.");
            return GAME_END;
        }
        // 만약 다른 문자가 입력되면 exception 발생
        Validation.checkChoiceRestart(selectNumber);
        return Validation.WRONG_INPUT_EXCEPTION;
    }
}
