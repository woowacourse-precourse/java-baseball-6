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
        Exception.checkUserInput(inputDigits);

        for(int idx = 0; idx < 3; idx++){
            userNumbers[idx] = inputDigits[idx] - '0';
        }
    }

    public int countStrikes(){
        int strikeNum = 0;
        for(int idx = 0; idx < 3; idx++){
            if(!computerNumbers.containsKey(userNumbers[idx])){
                continue;
            }

            if(computerNumbers.get(userNumbers[idx]) == idx){
                strikeNum++;
            }
        }
        return strikeNum;
    }

    public int countBalls(){
        int ballNum = 0;
        for(int idx = 0; idx < 3; idx++){
            if(!computerNumbers.containsKey(userNumbers[idx])){
                continue;
            }

            if(computerNumbers.get(userNumbers[idx]) != idx){
                ballNum++;
            }
        }
        return ballNum;
    }

    public boolean gameResult(int strikeNum, int ballNum){

        if(strikeNum != 0 && ballNum == 0){
            System.out.println(strikeNum + "스트라이크");
        }
        else if(strikeNum == 0 && ballNum != 0){
            System.out.println(ballNum + "볼");
        }
        else if(strikeNum != 0 && ballNum != 0){
            System.out.println(ballNum + "볼 " + strikeNum + "스트라이크");
        }
        else{
            System.out.println("낫싱");
        }

        if(strikeNum == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
