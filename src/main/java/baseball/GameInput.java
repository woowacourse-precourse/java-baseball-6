package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class GameInput {
    public List<Integer> getUserNumber(){
        // FEAT : 3. 사용자에게 수를 입력받는 기능
        String userInput = Console.readLine();
        // end
        // FEAT : 4. 사용자가 잘못된 값을 입력할 경우 예외를 발생시키는 기능
        List<Integer> userNumber = new ArrayList<>();
        if (userInput != null && userInput.length() == 3 && userInput.matches("[1-9.]+")) {
            for (int i = 0; i < userInput.length(); i++) {
                int parseNumber = userInput.charAt(i) - '0';
                userNumber.add(parseNumber);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return userNumber;
        // end
    }
    public static Boolean getRestartOption(){
        String restartOption = Console.readLine();
        if (restartOption.equals("1")|| restartOption.equals("2")) {
            if (restartOption.equals("1")) {
                return true;
            }else{
                return false;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
