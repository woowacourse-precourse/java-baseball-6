package console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    // TODO: 2023/10/24 이 클래스의 매서드를 Static 으로 둘것인가?
    public static final String NOT_VALID = "NOT_VALID";
    public String getUserInput(){
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public boolean isContinuable(){
        String userInput = Console.readLine();
        return userInput.equals("1");
    }

    private void validateInput(String given) {
        if (given.length() != 3) {
            throw new IllegalArgumentException(NOT_VALID);
        }
        try{
            Integer.parseInt(given);
        } catch (Exception e){
            throw new IllegalArgumentException(NOT_VALID);
        }
        if (isDuplicatedNumber(given)){
            throw new IllegalArgumentException(NOT_VALID);
        }
    }

    private boolean isDuplicatedNumber(String input) {
        Set<Character> charSet = new HashSet<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            charSet.add(c);
        }
        return charSet.size() != 3;
    }
}