package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        int userflag = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(userflag == 1){
            List<Integer> userInputNum = new ArrayList<>();
            List<Integer> computerNum = new ArrayList<>();
            System.out.println("숫자를 입력해주세요 : ");
            String userInputString = Console.readLine();
            checkUserInput(userInputString);
            getUserInput(userInputString, userInputNum);
            getComputerNum(computerNum);
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

    static void getUserInput(String userInputString, List<Integer> userInputNum){
        // Convert user input from a string to an integer ArrayList.
        for(int i = 0; i < 3; i++){
            userInputNum.add((int)(userInputString.charAt(i) - '0'));
        }
    }

    static void getComputerNum(List<Integer> computerNum){
        // Generate the computer's numbers.
        while (computerNum.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
    }
}

