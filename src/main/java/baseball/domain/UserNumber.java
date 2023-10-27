package baseball.domain;

import baseball.excpetion.InputException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private InputException numberException;

    public UserNumber(){
        numberException = new InputException();

    }

    public List<Integer> inputUserNumber(){
        String userNumber = Console.readLine();
        numberException.validNumberLength(userNumber);
        numberException.validDuplicateNumber(userNumber);
        numberException.validNumberType(userNumber);
        return stringToList(userNumber);

    }

    public List<Integer> stringToList(String userNumber){
        List<Integer> userNumberList = new ArrayList<>();
        for(int i=0; i<userNumber.length(); i++){
            userNumberList.add(Integer.parseInt(String.valueOf(userNumber.charAt(i))));
        }
        return userNumberList;
    }
}
