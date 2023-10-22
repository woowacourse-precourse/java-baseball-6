package baseball;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

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
        userNumbers = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        char[] inputDigits = userInput.toCharArray();
        // 예외 처리

        for(int idx = 0; idx < 3; idx++){
            userNumbers[idx] = inputDigits[idx] - '0';
        }
    }

    public int countStrikes(){
    }

    public int countBalls(){
    }

    public boolean gameResult(int strikeNum, int ballNum){
    }
}
