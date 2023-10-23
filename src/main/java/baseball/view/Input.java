package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String userGuess(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void consoleClose(){
        Console.close();
    }

    public static int[] stringToInt(String userNumber){
        int[] userNum = new int[userNumber.length()];
        for (int i = 0; i < userNumber.length(); i++) {
            userNum[i] = Character.getNumericValue(userNumber.charAt(i));
        }
        return userNum;
    }
}