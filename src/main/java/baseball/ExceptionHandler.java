package baseball;

public class ExceptionHandler {

    public void isInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicate(String userInput){
        if (userInput.chars().distinct().count()!=userInput.length())
            throw new IllegalArgumentException();
    }

    public void isRightDigit(String userInput){
        int digit = 3;
        if (userInput.length()!= digit)
            throw new IllegalArgumentException();
    }

    public void checkIsRightChoice(String  userInput){
        if (!(userInput.equals("1") || userInput.equals("2")))
            throw new IllegalArgumentException();
    }

}