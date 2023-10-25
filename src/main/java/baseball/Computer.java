package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    // 컴퓨터가 생성하는 숫자를 저장할 배열
    List<Integer> computerNumber = new ArrayList<>();

    public Computer (){
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
    public static void run(){
        Computer computer;
        do{
            computer = new Computer();
            computer.start();
        } while(computer.reStart());

    }
    private void start(){
        String inputNumber;
        do{
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = Console.readLine();
        } while(gameResult(inputNumber) != true);
    }

    private boolean gameResult(String inputNumber){
        int[] inputNumberArray = changedArray(inputNumber);
        int strike = countStrike(inputNumberArray);
        int ballPlusStrike = countBall(inputNumberArray);
        printResult(strike,ballPlusStrike);

        if(strike == 3){
            return true;
        } else{
            return false;
        }
    }
    private int[] changedArray(String inputString){
        int[] intArray = new int[3];
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("길이가 맞지 않습니다");
        }
        if (!inputString.matches("^[0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        for (int i = 0; i < inputString.length(); i++){
            intArray[i] = Integer.parseInt(inputString.substring(i, i+1));
        }
        return intArray;
    }

    private boolean reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if(inputString.equals("1")){
            return true;
        }else if(inputString.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException("[Game.restart()]: 숫자를 입력해주세요");
        }
    }

    private int countStrike(int[] inputNumber){
        int strike = 0;
        for (int i =0; i < computerNumber.size(); i++){
            if(inputNumber[i] == computerNumber.get(i)){
                strike++;
            }
        }
        return strike;
    }

    private int countBall(int[] inputNumber){
        int ball = 0;
        for (int i : inputNumber){
            if(computerNumber.contains(i)){
                ball++;
            }
        }
        return ball;
    }
    private void printResult(int strike, int ballPlusStrike){
        int ball = ballPlusStrike - strike;
        if(ballPlusStrike == 0){
            System.out.println("낫싱");
        }else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
        printSuccess(strike);
    }
    private void printBall(int ball){
        if(ball != 0){
            System.out.print(ball + "볼 ");
        }
    }
    private void printStrike(int strike){
        if (strike != 0) {
            System.out.print(strike + "스트라이크 ");
        }
    }
    private void printSuccess(int strike){
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}