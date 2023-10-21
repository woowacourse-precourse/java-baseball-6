package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public static void startGame(){
        while (true){
            System.out.println("게임시작");
            if(!Data.isCreated) {
                initComputerNumber();
                Data.isCreated = true;
            }
            System.out.println(Data.computerNumber); // 디버깅용
            setPlayerNumber();
            System.out.println(Data.playerNumber); //디버깅용
            getResult();
            System.out.println(Data.strike + " 스트라이크 " + Data.ball + "볼");// 디버깅용

        }
    }
    static void getResult(){
        int count = 0;
        Data.strike = 0;
        Data.ball = 0;
        for(int index = 0; index < Data.playerNumber.size(); index++){
            if(Data.computerNumber.get(index).equals(Data.playerNumber.get(index))  ) Data.strike += 1;
            if(Data.computerNumber.contains(Data.playerNumber.get(index))) Data.ball += 1;
        }
        Data.ball -= Data.strike;
    }
    static void initComputerNumber(){
        Data.computerNumber = new ArrayList<>();
        while (Data.computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!Data.computerNumber.contains(randomNumber)){
                Data.computerNumber.add(randomNumber);
            }
        }
    }
    static void setPlayerNumber() throws IllegalArgumentException{
        Data.playerNumber = new ArrayList<>();
        String input = playerInput();
        int toIntInput = Integer.parseInt(input);
        while (toIntInput > 0){
            Data.playerNumber.add(toIntInput%10);
            toIntInput /= 10;
        }
        Collections.reverse(Data.playerNumber);
        exceptionCheck();

    }
    static void exceptionCheck(){
        if(Data.playerNumber.contains(0)){
            throw new IllegalArgumentException();
        }
        if(Data.playerNumber.size() != 3){
            throw new IllegalArgumentException();
        }
        if(!redundantCheck()){
            throw new IllegalArgumentException();
        }
    }
    static boolean redundantCheck(){
        Set<Integer> inputSet = new HashSet<>(Data.playerNumber);

        if(inputSet.size() != Data.playerNumber.size()) return false;
        return true;
    }

    static String playerInput(){
        String input = Console.readLine();
        return input;
    }
}
