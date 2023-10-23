package baseball;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer>  userNumber(){
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
       for(int i=0; i< userNumber.length();i++) {
            char userchar = userNumber.charAt(i);
            int translateNumber = Character.getNumericValue(userchar);
            userNumbers.add(translateNumber);
        }
        return userNumbers;
    }

}
