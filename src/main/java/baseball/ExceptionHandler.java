package baseball;

public class ExceptionHandler {

    private static final int digit = 3;

    public void checkIsInteger(String userInput){
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

    public void checkRightDigit(String userInput){
        if (userInput.length()!=digit)
            throw new IllegalArgumentException();
    }

    public void checkIsRightChoice(Integer userInput){
        if (!(userInput==1 || userInput==2))
            throw new IllegalArgumentException();
    }

}