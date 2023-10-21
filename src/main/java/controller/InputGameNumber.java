package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputGameNumber {

    /**
     * 사용자가 게임 숫자를 입력하는 기능
     * 숫자를 입력하면 List로 반환하게 구현
     */
    public List<Integer> inputNum(){
        String tmp = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for(int i=0; i<tmp.length(); i++){
            userNum.add(Character.getNumericValue(tmp.charAt(i)));
        }
        return userNum;
    }
}
