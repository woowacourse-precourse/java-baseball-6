package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int userflag = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(userflag == 1){
            int[] userInputNum = new int[3];
            System.out.println("숫자를 입력해주세요 : ");
            String userInputString = Console.readLine();
            checkUserInput(userInputString);
            convertUserInput(userInputString, userInputNum);
        }
    }

    static void checkUserInput(String input) throws IllegalArgumentException{
        String errorMessage = "[error] 올바르지 않은 입력입니다.";
        // Check the input size is 3.
        if(input.length() != 3) throw new IllegalArgumentException(errorMessage);
        // Check each character is number.
        for(int i = 0; i < input.length(); i++){
            if(!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) throw new IllegalArgumentException(errorMessage);
        }
        // Check number are different each other.
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if(firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum) throw new IllegalArgumentException(errorMessage);
    }

    static void convertUserInput(String userInputString, int[] userInputNum){
        // Convert user input from a string to an integer array.
        for(int i = 0; i < userInputString.length(); i++){
            userInputNum[i] = (int)(userInputString.charAt(i) - '0');
        }
    }

    
}

