package computer;

import camp.nextstep.edu.missionutils.Randoms;
import player.Player;

import static constants.MessageConstants.*;
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



    // 스트라이크 갯수 파악
    private int cntStrike(String inputNum){
        int strike = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if(randomString.charAt(i) == inputNum.charAt(i)){ strike++;
            }
        } return strike;
    }

    // total = strike + ball
    private int cntTotal(String inputNum){
        int total = 0;
        for (char c : inputNum.toCharArray()) {
            if(randomString.contains(c+" ")){
                total++;
            }
        }
        return total;
    }

    private boolean chkResult(String inputNum) {
        int total = cntTotal(inputNum);
        int strike = cntStrike(inputNum);
        printResult(total, strike);

        return strike == SUCCESS_STRIKE;
    }

    // 결과 출력
    private void printResult(int total, int strike){
        int ball = total - strike;

        if(total == NOTHING){
            System.out.println(NOTHING_MESSAGE);
        } else if(strike == SUCCESS_STRIKE){
            System.out.println(SUCCESS_MESSAGE);
        }else {
            if(ball == 0){
                System.out.println(strike + STRIKE_MESSAGE);
            }else if(strike == 0){
                System.out.println(ball + BALL_MESSAGE);
            }else {
                System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            }
        }
    }
}
