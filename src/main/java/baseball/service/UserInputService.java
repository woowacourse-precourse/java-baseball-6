package baseball.service;
import baseball.domain.UserInput;
import camp.nextstep.edu.missionutils.Console;
public class UserInputService {
    static final int VALID_LENGTH = 3;
    static final char ONE = '1';
    static final char NINE = '9';
    public UserInput getUserInput(){
        UserInput userInput = new UserInput();
        userInput.setUserInput(Console.readLine());
        return userInput;
    }

    public void checkValidation(UserInput userInput){
        checkInputLength(userInput);
        checkValidNumber(userInput);
        checkDuplicateNumber(userInput);
    }

    private void checkInputLength(UserInput userInput){
        if (userInput.getUserInput().length() != VALID_LENGTH)
            throw new IllegalArgumentException("Invalid Input Length");
    }

    private void checkValidNumber(UserInput userInput){
        String stringUserInput = userInput.getUserInput();
        for (int i = 0; i < VALID_LENGTH; i++){
            betweenOneAndNine(stringUserInput.charAt(i));
        }
    }

    private void betweenOneAndNine(char ithChar){
        if (!(ithChar >= ONE && ithChar <= NINE))
            throw new IllegalArgumentException("Number Out Of Range");
    }

    private void checkDuplicateNumber(UserInput userInput){
        String compareStr = userInput.getUserInput();
        compareStr += compareStr.charAt(0);

        char before = compareStr.charAt(0);
        for (int i = 1; i < VALID_LENGTH + 1; i++){
            compareChar(before, compareStr.charAt(i));
            before = compareStr.charAt(i);
        }
    }

    private void compareChar(char a, char b){
        if (a == b)
            throw new IllegalArgumentException("There Exist Duplicate Number In Input");
    }



}
