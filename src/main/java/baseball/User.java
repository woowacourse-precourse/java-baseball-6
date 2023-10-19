package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int userNumber = 0;

    static boolean isParsableToInt(final String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
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
    }

    static void setUserNumber(int userNumber){
        User.userNumber = userNumber;
    }

    public static int getUserNumber(){
        return userNumber;
    }

    public static void readNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        setUserNumber(Integer.parseInt(input));
    }

}
