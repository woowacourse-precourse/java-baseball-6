package baseball;

public class InputValidator {
    private static final int EXPECTED_DIGIT=3;

    public void validateIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
    public void validateNoDuplicate(String userInput){
        if (userInput.chars().distinct().count()!=userInput.length())
            throw new IllegalArgumentException();
    }

    public void validateLength(String userInput){
        if (userInput.length()!= EXPECTED_DIGIT)
            throw new IllegalArgumentException();
    }

    public void validateChoice(String  userInput){
        if (!(userInput.equals("1") || userInput.equals("2")))
            throw new IllegalArgumentException();
    }

}