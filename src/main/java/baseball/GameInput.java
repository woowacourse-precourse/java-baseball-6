package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class GameInput {
    public List<Integer> getUserNumber(){
        String userInput = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();

        if (!isValid(userInput)){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInput.length(); i++) {
            userNumber.add(toInt(userInput.charAt(i)));
        }

        return userNumber;
    }
    public static int getRestartOption(){
        String restartOption = Console.readLine();
        if (restartOption.equals("1")) {
            return 1;
        }else if(restartOption.equals("2")){
            return 2;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public static Integer toInt(char str){
        return str-'0';
    }
    public static Boolean isValid(String str){
        if (str != null && str.length() == 3 && str.matches("[1-9.]+")) {
            return true;
        } else{
            return false;
        }
    }
}
