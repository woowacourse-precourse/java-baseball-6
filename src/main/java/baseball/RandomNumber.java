package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomNumber {
    private String randomNumber;

    public RandomNumber(){
        createRandomNumber();
    }

    public String getRandomNumber(){
        return randomNumber;
    }

    public void createRandomNumber(){
        List<String> list = new ArrayList<>();
        while(list.size()<3){
            String newNum = String.valueOf(Randoms.pickNumberInRange(1,9));
            if(!list.contains(newNum)){
                list.add(newNum);
            }
        }
        this.randomNumber = String.join("",list);
    }



}
