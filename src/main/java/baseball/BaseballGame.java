package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static List<Integer> computerNumber;
    final static int randomRangestart=0;
    final static int randomRangeend=9;
    final static int listSize=3;

    public static void gameStart(){
        int checkNum;
        userInterface.startWrite();
        generateRandomNumber();
        while(true){
            userInterface.inputWrite();
            userInterface.userInput();
            checkNum=userInterface.checkUserGuess(countBallAndStrike());
            if (checkNum==userInterface.endGameChoice){
                break;
            }else if(checkNum==userInterface.restartChoice){
                generateRandomNumber();
            }
        }
    }

    public static void generateRandomNumber(){
        List<Integer> tempComputerNumber = new ArrayList<>();
        while (tempComputerNumber.size() < listSize) {
            int randomNumber = Randoms.pickNumberInRange(randomRangestart, randomRangeend);
            if (!tempComputerNumber.contains(randomNumber)) {
                tempComputerNumber.add(randomNumber);
            }
        }
        computerNumber=tempComputerNumber;
    }

    public static int[] countBallAndStrike(){
        int strike=0;
        int ball=0;
        for(int i=0;i<listSize;i++) {
            if(computerNumber.contains(userInterface.userInputNumber.get(i))){
                if(computerNumber.indexOf(userInterface.userInputNumber.get(i))==i){
                    strike++;
                }else{
                    ball++;
                }
            }
        }
        return new int[] {ball, strike};
    }
}
