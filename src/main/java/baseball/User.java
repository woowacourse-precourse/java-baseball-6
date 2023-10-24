package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static String userNumber = null;

    static boolean isParsableToInt(final String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    static boolean hasDuplicateNumbers(final String input){
        boolean[] isExisted = new boolean[10];
        for(char digit: input.toCharArray()){
            if(isExisted[digit-'0']){
                return false;
            }
            isExisted[digit-'0'] = true;
        }
        return true;
    }

    static boolean isInRange(final String input){
        for(char digit: input.toCharArray()){
            if (digit < '1' || digit > '9'){
                return false;
            }
        }
        return true;
    }

    public static void validateInput(final String input){
        if(input == null){
            throw new IllegalArgumentException("Input value is null.");
        }
        if(!isParsableToInt(input)){
            throw new IllegalArgumentException("Input value is not integer.");
        }
        if(input.length() != 3){
            throw new IllegalArgumentException("Input 3 digit integer.");
        }
        if(!hasDuplicateNumbers(input)){
            throw new IllegalArgumentException("Input not duplicate numbers.");
        }
        if(!isInRange(input)){
            throw new IllegalArgumentException("Input enter value of each digit between 1 and 9");
        }
    }

    static void setUserNumber(String userNumber){
        User.userNumber = userNumber;
    }

    public static String getUserNumber(){
        return User.userNumber;
    }

    public static void readNumber(){
        String input = Console.readLine();
        validateInput(input);
        setUserNumber(input);
    }

}
