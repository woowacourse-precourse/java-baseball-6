

package Game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static constant.constant.*;
import static constant.StringError.*;

public class playGame {
    String answer = new String();

    public String makeNumber(){
        answer="";
        while(answer.length()<ANSWER_SIZE){
            int randomNum= Randoms.pickNumberInRange(START_NUM,END_NUM);
            if(!answer.contains(String.valueOf(randomNum))){
                answer+=String.valueOf(randomNum);
            }
        }
        /*
        for(char c: answer.toCharArray())
        {
            System.out.print(c);
        }*/



        return answer;
    }
    public static void start(){
        playGame game=new playGame();
        do{
            game.makeNumber();
            game.turn();
            if(game.restart())
            {
                game=new playGame();
            }
            else
            {
                break;
            }
        }while(true);
    }
    private void turn(){
        String inputString;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = Console.readLine();
            checkInputString(inputString);
        }while(checkGameResult(inputString)!= SUCCESS_BOOLEAN);
    }

    private void checkInputString(String inputString)
    {
        String tmp="";
        if (inputString.length() !=NORMAL_INPUT_LENGTH)
        {   //예외처리 : 문자열 길이 판단
            throw new IllegalArgumentException(wrongLengthInputError);
        }
        for(char c: inputString.toCharArray()) {
            //예외처리 : 음수 입력 및 문자입력
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(wrongTypeInputError);
            }
            // 예외처리 : 중복된 숫자 입력
            if(tmp.contains(String.valueOf(c))){
                throw new IllegalArgumentException(sameNumberError);
            }
            tmp+=String.valueOf(c);

        }
    }

    private int cntStrike(String inputNumber){
        int strike_cnt = 0;
        for (int i = 0; i<answer.length(); i++) {
            if(inputNumber.charAt(i) == answer.charAt(i)){
                strike_cnt++;
            }
        }
        return strike_cnt;
    }
    private int cntTotal(String inputString){
        int total_cnt = 0;
        for (char c : inputString.toCharArray()) {
            if(answer.contains(c+"")){
                total_cnt++;
            }
        }
        return total_cnt;
    }

    private boolean checkGameResult(String inputNumberString){
        int strike_cnt = cntStrike(inputNumberString);
        int total_cnt = cntTotal(inputNumberString);
        printResult(strike_cnt, total_cnt);

        return (strike_cnt == SUCCESS_STRIKE);
    }

    private void printResult(int strike_cnt, int total_cnt){
        int ball_cnt= total_cnt- strike_cnt;
        if(total_cnt==NOTHING){
            System.out.println(NOTHING_STRING);
        }
        else{
            if(ball_cnt !=0 && strike_cnt !=0)
            {
                System.out.println(ball_cnt+"볼 "+strike_cnt+"스트라이크");
            }
            else if(ball_cnt!=0){
                System.out.println(ball_cnt+"볼");
            }
            else if(strike_cnt!=0){
                System.out.println(strike_cnt+"스트라이크");
            }
        }
        if(strike_cnt==3){
            System.out.println(ANSWER_SIZE+SUCCESS_STRING);
        }
    }

    private boolean restart(){
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if(inputString.equals(RESTART_INPUT_STRING)){
            return true;
        }
        else if(inputString.equals(TERMINATE_INPUT_STRING)){
            return false;
        }
        else{
            throw new IllegalArgumentException(wrongInputError);
        }
    }
}
