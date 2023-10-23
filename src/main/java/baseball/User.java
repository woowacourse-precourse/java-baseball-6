package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int INPUT_SIZE = 3;
    private static final int FLAG_SIZE = 1;
    public String getUserInput(){
        Message.getStartMsg();
        String userInput = Console.readLine();
        if (!isLenError(userInput, INPUT_SIZE))
            throw new IllegalArgumentException("Invalid Length: " + userInput);
        if (!isWordError(userInput))
            throw new IllegalArgumentException("Word error is occurred : " + userInput);
        if (!isDupError(userInput))
            throw new IllegalArgumentException("Duplication Error is occurred : " + userInput);
        return userInput;
    }
    static public int newGameFlag(){
        String userInput = Console.readLine();
        int num;
        if (!isLenError(userInput, FLAG_SIZE))
            throw new IllegalArgumentException("Invalid Length: " + userInput);
        if (!isWordError(userInput))
            throw new IllegalArgumentException("Word error is occurred : " + userInput);
        num = Integer.parseInt(userInput);
        if (num < 1 || 2 < num)
            throw new IllegalArgumentException("range error is occurred : " + num);
        return num;
    }
    static private boolean isLenError(String input, int size){
        return input.length() == size;
    }

    static private boolean isWordError(String input){
        char word;
        for(int i = 0; i < input.length(); i++) {
            word = input.charAt(i);
            if(!Character.isDigit(word))
                return false;
        }
        return true;
    }

    static private boolean isDupError(String input){
        int[] tempArr = new int[SIZE];
        int tempNumber;
        for (int i = 0; i < SIZE; i++){
            tempNumber = Integer.parseInt(input.charAt(i) + "");
            if (Computer.isDup(tempArr, tempNumber))
                return false;
            tempArr[i] = tempNumber;
        }
        return true;
    }
}
