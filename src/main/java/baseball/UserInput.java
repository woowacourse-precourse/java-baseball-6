package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static List<Integer> inputNumber(){
        System.out.print("숫자를 입력해주세요 :");
        String input = Console.readLine();

        if(input.length() != 3 ){
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }

        List<Integer> user = new ArrayList<>();
        for(int i=0;i<3;i++){
            char digit = input.charAt(i);
            if(!Character.isDigit(digit)){
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            user.add(Character.getNumericValue(digit)) ;
        }

        return user;
    }
}
