package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Input {

    public static int restartInput(){
        int userInput = Integer.parseInt(Console.readLine());
        //유효성 검사
        return userInput;
    }

    public static int[] userInput(){
        String userInput = Console.readLine();
        int [] userNumbers = new int[3];
        for(int i = 0; i < 3; i++){
            userNumbers[i] = userInput.charAt(i) - '0';
        }
        //유효성 검사
        return userNumbers;
    }
}
