package baseball;

public class Application {
    public static void main(String[] args) {

    }
    
    static void checkUserInput(String input) throws IllegalArgumentException{
        String errorMessage = "[error] 올바르지 않은 입력입니다.";
        // check the input size is 3
        if(input.length() != 3) throw new IllegalArgumentException(errorMessage);
        // check each character is number
        for(int i = 0; i < input.length(); i++){
            if(!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) throw new IllegalArgumentException(errorMessage);
        }
        // check number are different each other
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if(firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum) throw new IllegalArgumentException(errorMessage);
    }
}

