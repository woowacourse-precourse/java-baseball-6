package baseball.controller;

import baseball.model.UserNum;

import java.util.ArrayList;
import java.util.List;

public class ValidUserNum {

    private UserNum userNum;

    public ValidUserNum(String s) {
        List<Integer> userNumList=new ArrayList<>();

        if (s.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Character> naturalNum=new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));

        for (int i = 0; i < 3; i++) {
            char c = s.charAt(i);
            if(naturalNum.contains(c)){
                int num = Character.getNumericValue(c);
                userNumList.add(num);
            }else{
                throw new IllegalArgumentException();
            }
        }

        if(userNumList.get(0) == userNumList.get(1)
                | userNumList.get(0) == userNumList.get(2)
                | userNumList.get(1) == userNumList.get(2)) {
            throw new IllegalArgumentException();
        }
        this.userNum = new UserNum(userNumList);
    }

    public UserNum getUserNum(){
        return this.userNum;
    }


}
