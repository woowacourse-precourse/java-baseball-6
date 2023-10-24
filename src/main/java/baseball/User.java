package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> getUserNum(){
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();

        for(String num : inputValue.split("")){
            user.add(Integer.parseInt(num));
        }
        if(inputValue.length() >3 && inputValue.length() <3){
            throw new IllegalArgumentException("유효한 숫자 범위 밖의 입력");
        }
        return user;
    }
}
