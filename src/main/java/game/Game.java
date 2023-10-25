package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static game.Constant.*;
import static game.Error.*;


/**
 *  runApp() ->전체 게임 프로그램 실행
 *  Game() -> 생성자를 통해 값들 초기화
 *
 *
 */
public class Game {
    static List<Integer> computer = new ArrayList<>();
    public Game() {
        while(computer.size()<SIZE){
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
/*
    public static void run(){
        Game game;
        do{
            game = new Game();
            game.runApp();

        }while(game.gameRestart());
    }
*/

    public static void runApp(){
        String inputString;
        System.out.println(START);
        while(true){
            System.out.println(INPUT);
            inputString = Console.readLine();
            if((checkResult(inputString))==SUCCESS_BOOLEAN){
                break;
            }
        }
        if(gameRestart()==true){
            computer.clear();
            Game game = new Game();
            game.runApp();
        }
    }
    private static boolean gameRestart(){
        System.out.println(RESTART_MSG);
        String inputRestart = Console.readLine();
        if(inputRestart.equals(RESTART)) {
            return true;
        }else if(inputRestart.equals(STOP)){
            return false;
        }else{
            throw new IllegalArgumentException(InputError);
        }
    }
    private static boolean checkResult(String inputString){
        int[] inputNumberArr = changeStringToInteger(inputString);
        int strike = getStrike(inputNumberArr);
        int ball = getBall(inputNumberArr);
        printResult(ball,strike);

        if(strike==SIZE){
            return true;
        }else{
            return false;
        }

    }
    private static int[] changeStringToInteger(String inputString){
        int[] inputInt = new int[SIZE];
        checkLength(inputString);
        for(int i=0;i<inputInt.length-1;i++){
            //예외 처리
            if(inputString.charAt(i)<'0' || inputString.charAt(i)>'9'){
                throw new IllegalArgumentException(InputTypeError);
            }
            inputInt[i] = Integer.parseInt(inputString.substring(i,i+1));
        }
        return inputInt;
    }
    private static void checkLength(String inputString){
        if(inputString.length()!=SIZE) {
            throw new IllegalArgumentException(InputLengthError);
        }
    }
    private static int getStrike(int[] inputNumberArr){
        int resultStrike=0;
        for(int i=0;i<computer.size();i++){
            if(inputNumberArr[i]==computer.get(i)){
                resultStrike++;
            }
        }
        return resultStrike;
    }
    private static int getBall(int[] inputNumberArr){
        int ball = 0;
        for (int i : inputNumberArr) {
            if(computer.contains(i)){
                ball++;
            }
        }
        return ball;
    }
    private static void printResult(int balls, int strikes){
        int ball = balls-strikes;
        if(balls==NOTHING_NUM)
            System.out.println(NOTHING);
        else{
            printBallStrike(ball,strikes);
            System.out.println();
        }
        successStrike(strikes);
    }
    private static void printBallStrike(int ball, int strike){
        if(ball!=0){
            System.out.println(ball+BALL);
        }
        if(strike!=0){
            System.out.println(strike+STRIKE);
        }
        successStrike(strike);
    }
    private static void successStrike(int strike){
        if(strike == SIZE){
            System.out.println(SUCCESS_STRING);
        }
    }
}
