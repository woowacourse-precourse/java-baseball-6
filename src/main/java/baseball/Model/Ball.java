package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    private Integer numberLength = null;
    private String number = "";


    public Ball(int numberLength){
        this.numberLength = numberLength;
    }

    public String generateNumbers(){
        number = "";
        while(number.length() < numberLength){
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!number.contains(Integer.toString(randomNumber))){
                number += randomNumber;
            }
        }

        return new String(number);
    }
}
