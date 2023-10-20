package Model;

import Util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private String userNumber;

    public User() throws IllegalArgumentException{
        try{
            String userInput = Console.readLine();
            Validator.validateUserInput(userInput);
            Validator.validateInputLength(userInput, 3);
            this.userNumber = userInput;
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    public String getuserNumber(){
        return userNumber;
    }

}
