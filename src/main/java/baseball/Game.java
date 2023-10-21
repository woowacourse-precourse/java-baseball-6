package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

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

}
