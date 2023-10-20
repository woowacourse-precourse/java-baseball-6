package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<Integer> inputNumber(){
        System.out.print("숫자를 입력해주세요 : " );
        String tmp = Console.readLine();
        List<Integer> threeNumList = strToArrayList(tmp);
        return threeNumList;
    }

    private List<Integer> strToArrayList(String tmp){
        List<Integer> threeNumList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            char digitChar = tmp.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            threeNumList.add(digit);
        }
        return threeNumList;
    }
}
