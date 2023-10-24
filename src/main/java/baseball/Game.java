package baseball;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    List<Integer> randomNum = new ArrayList<>();
    List<Integer> answerNum = new ArrayList<>();

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
        String answer;
        do{
            answer = getNum();
            changeIntArray(answer);
            validateDuplcate(answerNum);
        }while (checkResult()!=3);
    }
    public void changeIntArray(String answer) {
        answerNum.clear();
        for (int i = 0; i < 3; i++) {
            answerNum.add(answer.charAt(i) - '0');
        }
    }
    public String getNum(){
        System.out.print(GETNUM_MESSEAGE);
        String answer = Console.readLine();
        validateSize(answer);
        validateType(answer);

        return answer;
    }
    public void validateSize(String answer) {
        if(answer.length()!=3){
            throw new IllegalArgumentException();
        }
    }
    public void validateType(String answer) {
        if(!answer.matches("\\d+")){
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplcate(List<Integer> answerNum){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(answerNum);
        if(nonDuplicateNumbers.size() != answerNum.size()){
            throw new IllegalArgumentException();
        }
    }


    public int checkResult(){

        int strike=0;
        int ball=0;

        for(int i = 0; i<3;i++){

            int num =answerNum.get(i);

            if(randomNum.get(i)==num){
                strike++;
            } else if (randomNum.contains(num)) {
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

