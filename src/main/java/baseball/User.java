package baseball;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer>  userNumber(){
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        if(userNumber.length()!=3){
            throw new IllegalArgumentException("3자리 수를 입력해 주세요.");
        }
       for(int i=0; i< userNumber.length();i++) {
            char userchar = userNumber.charAt(i);
            int translateNumber = Character.getNumericValue(userchar);
                if (userNumbers.contains(translateNumber)) {
                    throw new IllegalArgumentException("서로 다른 3자리 수를 입력해 주세요.");
                }
            userNumbers.add(translateNumber);
        }
        return userNumbers;
    }

}
