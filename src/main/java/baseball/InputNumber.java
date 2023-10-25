package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public List<Integer> userNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNum =  new ArrayList<>();
        String input = Console.readLine();
        for (String number : input.split("")) {
            userNum.add(Integer.parseInt(number));
        }


        if(userNum.size() != 3 || userNum.contains(0)){
            throw new IllegalArgumentException("잘못된 형식의 값을 입력하셨습니다.");
        }

        return userNum;
    }
}
