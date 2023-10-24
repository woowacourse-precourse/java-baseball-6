package baseball;

import static constant.Constant.*;
import entity.AnswerNum;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final List<Integer> randomNum = new ArrayList<>();

    public void playGame(){
        System.out.println(PLAYGAME_INTRO);
        do{
            initGame();
            playTurn();
            System.out.println(PLAYGAME_OUTTRO);
        }while (restartGame());

    }
    public void initGame(){
        randomNum.clear();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }
    public void playTurn(){
        List<Integer> answerNum;
        do{
            AnswerNum answerInstance = new AnswerNum(getNum());
            answerNum = answerInstance.getAnswerNum();
        }while (checkResult(answerNum)!=3);
    }

    public String getNum(){
        System.out.print(GETNUM_MESSEAGE);
        return Console.readLine();
    }



    public int checkResult(List<Integer> answerNum){

        int strike=0;
        int ball=0;

        for(int i = 0; i<3;i++){

            int answernum =answerNum.get(i);
            if(randomNum.get(i)==answernum){
                strike++;
            } else if (randomNum.contains(answernum)) {
                ball++;
            }
        }
        printCheckResult(ball, strike);
        return strike;
    }

    public void printCheckResult(int ball, int strike) {

        if(ball !=0){
            System.out.print(ball + BALL_MESSEAGE);
        }
        if(strike !=0){
            System.out.print(strike + STRIKE_MESSEAGE);
        }
        if(strike ==0 && ball ==0){
            System.out.print(NOTHING_MESSEAGE);
        }

    }

    public boolean restartGame(){

        System.out.println(RESTARTGAME_INTRO);
        String s = Console.readLine();

        if(s.equals(RESTART_NUM)){
            return true;
        } else if (s.equals(EXIT_NUM)) {
            return false;
        }else {
            throw new IllegalStateException();
        }
    }

}

