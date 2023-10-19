package baseball.controller;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;



public class UserNumber {
    public List<Integer> userInputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> userInputNumbers = new ArrayList<>();
        String number = Console.readLine();

        for (char c : number.toCharArray()) {
            userInputNumbers.add(Character.getNumericValue(c));
        }
        return userInputNumbers;
    }

}
