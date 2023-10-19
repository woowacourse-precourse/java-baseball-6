package baseball;

public class User {

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

}
