package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    private static final Scanner SCANNER = new Scanner(System.in);
    public List<Integer> userInputThreeNumber() { // 3자리 사용자 수 입력받기
        String userInput = SCANNER.next(); // 사용자 입력
        return userInputThreeNumberVerification(userInput);
    }
    public int userInputGameFlag(){ //게임 다시 시작 또는 종료 명령 입력받기
        int gameRestart = 1;
        try {
            gameRestart = SCANNER.nextInt();
        } catch (InputMismatchException e) { // 입력을 문자로 입력했을 때
            throw new IllegalArgumentException("문자를 입력하셨습니다.");
        }
        if (gameRestart != 1 && gameRestart != 2) { // 입력이 1,2가 아닐 때
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
        return gameRestart;
    }
    private List<Integer> userInputThreeNumberVerification(String userInput){ // 사용자 수 검증
        List<Integer> user = new ArrayList<>();
        try {
            for (String i : userInput.split("")) {
                int bit = Integer.parseInt(i);
                if (!user.contains(bit)) {
                    user.add(bit);
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하셨습니다."); // 사용자가 올바르지 않은 입력을 넣었을 때
        }
        if (user.size() != 3 || userInput.length() != 3) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 3자리의 서로 다른 수를 입력해주세요."); // 사용자가 올바르지 않은 입력을 넣었을 때
        }
        return user;
    }

}