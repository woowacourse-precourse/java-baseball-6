package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {

    public static void startGame(){
        System.out.println("게임시작");
        initComputerNumber();

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
    static void setPlayerNumber(){
        String input = playerInput();
        int toIntInput = Integer.parseInt(input);
        while (toIntInput > 0){
            Data.playerNumber.add(toIntInput%10);
            toIntInput /= 10;
        }
        Collections.reverse(Data.playerNumber);


    }

    static String playerInput(){
        String input = Console.readLine();
        return input;
    }
}
