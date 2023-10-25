package baseball.model;

public class User {

    private String userNumber;

    public String getUserNumber(){
        return userNumber;
    }
    public void setUserNumber(String userInput) {
        this.userNumber = userInput;
    }

    public void validateUserInput(String userInput) throws IllegalArgumentException {
        String regex = "[1-9]+";
        boolean isInvalidDigit = !userInput.matches(regex);

        if (isInvalidDigit || userInput.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

}
