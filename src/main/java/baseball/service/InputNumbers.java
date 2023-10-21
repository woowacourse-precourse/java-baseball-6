package baseball.service;

import baseball.vo.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    public static User setInputNumber(){
        List<Integer> inputNumber = new ArrayList<>();
        String input = Console.readLine();
        for(char inputChar: input.toCharArray()){
            inputNumber.add(Character.getNumericValue(inputChar));
        }
        User user = new User();
        user.setUserNumbers(inputNumber);
        return user;
    }
}
