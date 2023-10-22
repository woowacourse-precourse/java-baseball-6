package baseball;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;
class BaseballGame{
    private HashMap<Integer, Integer> computerNumbers;
    private int[] userNumbers;

    public void play(){
        generateComputerNumbers();

        boolean gameIsOver = false;
        while(!gameIsOver){
            userNumbersInput();

            int strikeNum = countStrikes();
            int ballNum = countBalls();

            gameIsOver = gameResult(strikeNum, ballNum);
        }
    }

    public void generateComputerNumbers(){
        computerNumbers = new HashMap<>();
        int idx = 0;
        while(computerNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumbers.containsKey(randomNumber)){
                computerNumbers.put(randomNumber, idx++);
            }
        }
    }

    public void userNumbersInput(){
    }

    public int countStrikes(){
    }

    public int countBalls(){
    }

    public boolean gameResult(int strikeNum, int ballNum){
    }
}
