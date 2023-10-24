package computer;

import camp.nextstep.edu.missionutils.Randoms;

import game.Ball;
import static constants.NumConstants.*;

public class Computer {

    String randomString = new String();

    // 3자리 난수 생성
    public String getRandomNumbers(){
        randomString = "";
        while(randomString.length() < ANSWER_SIZE){
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if(!randomString.contains(String.valueOf(randomNum))){
                randomString += String.valueOf(randomNum);
            }
        }
        return randomString;
    }

    public int cntStrike(String inputNum){
        int strike = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if(randomString.charAt(i) == inputNum.charAt(i)){ strike++;
            }
        } return strike;
    }







}
