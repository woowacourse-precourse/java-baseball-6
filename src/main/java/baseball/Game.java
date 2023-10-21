package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public static void startGame(){
        System.out.println("게임시작");
        initComputerNumber();
        setPlayerNumber();
        System.out.println(Data.playerNumber);
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
