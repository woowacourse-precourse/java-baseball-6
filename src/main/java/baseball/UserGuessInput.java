package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserGuessInput {
    static List<Integer> userInput = new ArrayList<>();

    public static List<Integer> getUserInput() {


        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();
        List<Integer> userGuessNumbers = new ArrayList<>();

        if(userInput.length() !=  3){
            throw new IllegalArgumentException("잘못된 자릿수를 입력하셨네요.");
        }

        for (char singleDigitChar : userInput.toCharArray()){
            int singleDigitInt = Character.getNumericValue(singleDigitChar);
            if(!(singleDigitInt >= 1 && singleDigitInt <= 9)){
                throw new IllegalArgumentException("잘못된 수를 입력하셨네요.");
            }
            userGuessNumbers.add(singleDigitInt);
        }

        //for-each문 서로다른 세자리 수 각 자리
        return userGuessNumbers;
    }
}

