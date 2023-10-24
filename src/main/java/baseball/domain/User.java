package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<Integer> userNumbers;

    public List<Integer> getUserNumber(){
        return userNumbers;
    }

    public List<Integer> setUserNumber(String inputNumbers){
        userNumbers = new ArrayList<>();
        for(int i=0; i<3; i++){
            userNumbers.add(inputNumbers.charAt(i) - '0');
        }
        return userNumbers;
    }

    public List<Integer> inputUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        return setUserNumber(inputNumbers);
    }
}
