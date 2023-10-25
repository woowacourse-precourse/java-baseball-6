package baseballgame;

import static constant.Constant.*;
import static constant.StringError.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * run -> 전체 프로그램 실행을 담당.
 * playOneGame -> 한번의 게임을 실행
 * ckeckRestart -> 재시작 여부 확인
 * getStrike -> 스트라이크 개수 확인
 * getBall -> 볼 개수 확인
 */
public class Game {
    List<Integer> answer = new ArrayList<>();

    public Game(){
        while(answer.size() < ANSWER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }

        for (Integer integer : answer) {
            System.out.println(integer.toString());
        }
    }

    public static void run(){
        //엔트리 포인트
        Game game;
        do{
            game = new Game();
            game.playGameOnce();
        }while(game.restart());
    }

    private void playGameOnce(){
        String inputString;
        do{
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();
            //changeInputStringToIntArray(inputString);
        }while(checkGameResult(inputString) != SUCCESS_BOOLEAN);
    }

    private boolean checkGameResult(String inputNumberString){
        int[] inputNumberArray = changeInputStringToIntArray(inputNumberString);
        int strike = getStrike(inputNumberArray);
        int ballWithStrike = getBall(inputNumberArray);
        printResult(strike, ballWithStrike);

        if(strike == SUCCESS_STRIKE){
            return true;
        }else{
            return false;
        }

    }
    private void printResult(int strike, int ballWithStrike){
        int ball = ballWithStrike - strike;
        if(ballWithStrike == NOTHING) {
            printNothing();
        }else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
        printSuccess(strike);

    }
    private void printNothing(){
        System.out.println(NOTHING_STRING);
    }
    private void printBall(int ball){
        if(ball != 0){
            System.out.print(ball + BALL_STRING);
        }
    }
    private void printStrike(int strike){
        if (strike != 0) {
            System.out.print(strike + STRIKE_STRING);
        }
    }
    private void printSuccess(int strike){
        if(strike == SUCCESS_STRIKE){
            System.out.println(SUCCESS_STRING);
        }
    }

    private int[] changeInputStringToIntArray(String inputString){ //
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        verifyInputStringLength(inputString, NORMAL_INPUT_LENGTH);
        for(int i = 0; i<inputString.length(); i++){
            if(inputString.charAt(i) < '0' || inputString.charAt(i) > '9'){
                throw new IllegalArgumentException(wrongTypeInputError);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i+1));
        }
        return intArray;
    }
    private void verifyInputStringLength(String inputString, int correctLength){
        if(inputString.length() != correctLength){
            throw new IllegalArgumentException(wrongLengthInputError + "\nExpect : " + correctLength + "\nInput : " + inputString.length());
        }
    }
    private boolean restart(){
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if(inputString.equals(RESTART_INPUT_STRING)){
            return true;
        }else if(inputString.equals(TERMINATE_INPUT_STRING)){
            return false;
        }else{
            throw new IllegalArgumentException("[Game.restart()]:"+ wrongInputError);
        }
    }
    private int getStrike(int[] inputNumber){
        int strike = 0;
        for (int i = 0; i<answer.size(); i++) {
            if(inputNumber[i] == answer.get(i)){
                strike++;
            }
        }
        return strike;
    }
    private int getBall(int[] inputNumber){
        int ball = 0;
        for (int i : inputNumber) {
            if(answer.contains(i)){
                ball++;
            }
        }
        return ball;
    }
}