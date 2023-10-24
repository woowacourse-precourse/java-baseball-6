package BaseballGame;

import static Utills.Messages.*;
import static Utills.Check.*;
import static Utills.Define.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class BaseballGame {
    List<Integer> computer = new ArrayList<>();
    public BaseballGame(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static void run(){
        gameStartMessage();
        BaseballGame game;
        do{
            game = new BaseballGame();
            game.play();
        }while(game.reStart());
    }
    private void play(){
        String answer;
        do {
            inputRequestMessage();
            answer = Console.readLine();
            checkIsValidAnswer(answer);
        }while(isEnd(answer));
    }

    private boolean isEnd(String answer){
        int[] answers = changeStringToIntList(answer);
        int ball = countBall(answers);
        int strike = countStrike(answers);
        ball -= strike;

        gameMessage(ball,strike);

        return !(strike == answer.length());
    }



    private int countBall(int[] answers){
        int ball = 0;
        for(int answer : answers){
            if(computer.contains(answer)){
                ball++;
            }
        }
        return ball;
    }
    private int countStrike(int[] answers){
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if(answers[i] == computer.get(i)){
                strike++;
            }
        }
        return strike;
    }
    private int[] changeStringToIntList(String answers){
        int[] intList = new int[answers.length()];
        for(int i = 0; i < answers.length(); i++){
            intList[i] = answers.charAt(i) - '0';
        }
        return intList;
    }

    private boolean reStart(){
        gameReStartMessage();
        String reQuest = Console.readLine();
        return reStartRequset(reQuest);
    }
    private boolean reStartRequset(String a){
        if(Objects.equals(a, ReStart)){
            return true;
        }else if(Objects.equals(a, Quit)){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }


}
