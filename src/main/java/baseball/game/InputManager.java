package baseball.game;

import baseball.GameManager;

import java.util.HashSet;
import java.util.Scanner;

public class InputManager {
    public static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void printInfoMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public String requestInput() {
        System.out.println(REQUEST_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public String getBaseballNumberFromUser(InputManager inputManager) {
        String userBaseballNumber = "";
        while (true) {
            inputManager.printInfoMessage();
            userBaseballNumber = inputManager.requestInput();
            boolean isOk = validateUserBaseballNumber(userBaseballNumber);
            if (isOk) {
                break;
            }
        }
        return userBaseballNumber;
    }

    public boolean validateUserBaseballNumber(String userBaseballNumber) {
        HashSet<Character> validateNumberList = new HashSet<>();
        for (int i = 0; i < userBaseballNumber.length(); i++) {
            validateNumberList.add(userBaseballNumber.charAt(i));
        }
        return validateNumberList.size() == 3 && userBaseballNumber.length() == 3;
    }
}
