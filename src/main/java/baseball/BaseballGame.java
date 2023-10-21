package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static List<Integer> numOfComputer;

    private static void setNumOfComputer(){
        numOfComputer = new ArrayList<>();
        while (numOfComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numOfComputer.contains(randomNumber)) {
                numOfComputer.add(randomNumber);
            }
        }
    }

    public static void startGame(){
        Baseball_output.printStart();
        setNumOfComputer();
        try{
            do{
                Baseball_Input.setUserInput();

            }while(true);

        }catch (IllegalArgumentException e){
            throw e;
        }

    }

    public static void run(){
        try{
            do{
                startGame();
            }while(Baseball_Input.setRestartNum());

        }catch (IllegalArgumentException e){
            throw e;
        }

    }

}
