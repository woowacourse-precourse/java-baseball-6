package baseball.domain;

import baseball.error.ChoiceError;
import baseball.error.InputError;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> inputUserNumber() {
        String input = Console.readLine();
        InputError.checkUserNumber(input);
        List<Integer> inputToList = stringToList(input);
        return inputToList;
    }

    private static List<Integer> stringToList(String input){
        List<Integer> inputList = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char inputChar = input.charAt(i);
            int digit = Character.getNumericValue(inputChar);
            inputList.add(digit);
        }
        return inputList;
    }


    public static String inputChoiceNumber() {
        String input = Console.readLine();
        ChoiceError.checkChoiceNumber(input);
        return input;
        //return Console.readLine();
    }

}
