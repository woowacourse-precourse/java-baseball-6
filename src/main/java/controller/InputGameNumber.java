package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputGameNumber {
    private int number = 3;
    public List<Integer> inputNum(){
        String tmp = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for(int i=0; i<number; i++){
            userNum.add(Character.getNumericValue(tmp.charAt(i)));
        }
        return userNum;
    }
}
