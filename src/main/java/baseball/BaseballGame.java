package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static List<Integer> numOfComputer;
    private static List<Integer> userInput;
    private static boolean isThreeStrike;
    private static int ball;
    private static int strike;

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
                initGameMembers();
                Baseball_Input.setUserInput();
                userInput = Baseball_Input.getUserInput();
                countBallandStrike();
                printBallandStrike();

            }while(!isThreeStrike);

        }catch (IllegalArgumentException e){
            throw e;
        }

    }

    public static void countBallandStrike(){

        for (int userIndex = 0; userIndex  < 3; ++userIndex) {
            int tmpUser = userInput.get(userIndex);
            for(int comIndex = 0; comIndex < 3; comIndex++){
                int tmpCom = numOfComputer.get(comIndex);
                if(tmpUser == tmpCom && userIndex == comIndex){
                    strike +=1;
                    continue;
                }
                if(tmpUser == tmpCom){
                    ball +=1;
                }
            }
        }

    }

    public static void printBallandStrike(){

        if(ball == 0 && strike == 0){
            Baseball_output.printNothing();
            return;
        }

        if(ball == 0 && strike != 0){
            Baseball_output.printStrike(strike);
            if(strike == 3) {
                Baseball_output.printGameEnd();
                isThreeStrike = true;
                return;
            }
            return;
        }

        if(ball != 0 && strike == 0){
            Baseball_output.printBall(ball);
            return;
        }

        Baseball_output.printBallAndStrike(ball,strike);

    }

    public static void initGameMembers(){
        isThreeStrike = false;
        ball = 0;
        strike = 0;
        return;
    }

    public static void run(){
        try{
            do{
                startGame();
                Baseball_output.printRestart();
                Baseball_Input.setRestartNum();
            }while(Baseball_Input.getRestartNum() == 1);

        }catch (IllegalArgumentException e){
            throw e;
        }

    }

}
