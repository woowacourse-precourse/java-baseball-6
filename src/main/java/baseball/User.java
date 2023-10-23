package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int SIZE = 3;
    public String userInput(){
        Message.getStartMsg();
        String userInput = Console.readLine();
        if (!checkLenError(userInput))
            throw new IllegalArgumentException("Invalid Length: " + userInput);
        if (!checkWordError(userInput))
            throw new IllegalArgumentException("Word error is occurred : " + userInput);
        if (!checkDupError(userInput))
            throw new IllegalArgumentException("Duplication Error is occurred : " + userInput);
        return userInput;
    }

    static boolean checkLenError(String input){
        return input.length() == 3;
    }

    static boolean checkWordError(String input){
        char word;
        for(int i = 0; i < SIZE; i++) {
            word = input.charAt(i);
            if(!Character.isDigit(word))
                return false;
        }
        return true;
    }

    static boolean checkDupError(String input){
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
