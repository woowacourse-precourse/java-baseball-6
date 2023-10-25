package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static game.Constant.*;
import static game.Error.*;


/**
 *  playGame() ->전체 게임 프로그램 실행
 *  Game() -> 생성자를 통해 값들 초기화 컴퓨터 값 할당
 *  checkResult() -> 게임 결과 체크
 *  restart() -> 게임을 재시작 여부 확인
 *  getBall(), getStrike() -> 볼, 스트라이크 개수계산
 */
public class Game {
    List<Integer> computer;
    public Game(){
        computer = new ArrayList<>();
        while(computer.size() < SIZE){
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
    //게임 실행 메소드
    public static void runApp(){
        Game game = new Game();
        game.playGame();

    }
    private void playGame(){
        String inputString;
        System.out.println(START);
        while(true){
            System.out.println(INPUT);
            inputString = Console.readLine();
            if((checkResult(inputString))==SUCCESS_BOOLEAN){
                break;
            }
        }
        if(restart()==true){
            Game game = new Game();
            game.playGame();
        }
    }
    //결과 체크 관련 메소드
    private boolean checkResult(String inputNumberString){
        int[] inputNumberArray = changeStringToArray(inputNumberString);
        int strike = getStrike(inputNumberArray);
        int ballWithStrike = getBall(inputNumberArray);
        printResult(strike, ballWithStrike);
        if(strike == SIZE){
            return true;
        }else{
            return false;
        }
    }
    private int[] changeStringToArray(String inputString){ //
        int[] intArray = new int[SIZE];
        checkStringLength(inputString);
        for(int i = 0; i<inputString.length(); i++){
            if(inputString.charAt(i) < '0' || inputString.charAt(i) > '9'){
                throw new IllegalArgumentException(InputTypeError);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i+1));
        }
        return intArray;
    }
    private void checkStringLength(String inputString){
        if(inputString.length() != SIZE){
            throw new IllegalArgumentException(InputLengthError);
        }
    }
    //볼, 스트라이크 개수 메소드
    private int getStrike(int[] inputNumber){
        int strike = 0;
        for (int i = 0; i<computer.size(); i++) {
            if(inputNumber[i] == computer.get(i)){
                strike++;
            }
        }
        return strike;
    }
    private int getBall(int[] inputNumber){
        int ball = 0;
        for (int i : inputNumber) {
            if(computer.contains(i)){
                ball++;
            }
        }
        return ball;
    }
    //결과 출력 관련 메소드
    private void printResult(int strike, int ballWithStrike){
        int ball = ballWithStrike - strike;
        if(ballWithStrike == NOTHING_NUM) {
            System.out.println(NOTHING);
        }else {
            printBallStrike(ball, strike);
        }
        printSuccess(strike);

    }
    private void printBallStrike(int ball, int strike){
        if(ball != 0){
            System.out.print(ball + BALL);
        }
        if (strike != 0) {
            System.out.print(strike + STRIKE);
        }
    }
    private void printSuccess(int strike){
        if(strike == SIZE){
            System.out.println(SUCCESS_STRING);
        }
    }
    //재시작 여부 메소드
    private boolean restart(){
        System.out.println(RESTART_MSG);
        String inputString = Console.readLine();
        if(inputString.equals(RESTART)){
            return true;
        }else if(inputString.equals(STOP)){
            return false;
        }else{
            throw new IllegalArgumentException(InputError);
        }
    }
}