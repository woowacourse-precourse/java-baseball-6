package baseball.Service;

import baseball.View.GameMessage;
import baseball.base.GameInit;
import baseball.base.RandomPick;
import baseball.base.UserNumbers;
import camp.nextstep.edu.missionutils.Console;

public class PlayballGame {

    UserNumbers userNumbers = new UserNumbers();
    static GameInit gameInit;

    public static void readyGame(){
        //기능 1. 랜덤 수 뽑기
        String computerNumbers = RandomPick.createComputerNumbers();
        gameInit = new GameInit(computerNumbers);
    }

    // 기능 2. 게임 플레이
    public void gamePlay(){
        int strike = 0;
        while(strike !=3){
            exeGame();
            strike = gameInit.getStrikeCount();
        }
        GameMessage.gameoverMessage();
    }
    public void exeGame(){

        userNumbers.setUserNumbers(receiveUserNumbers());
        calculateResult();
        GameMessage.gameResultMessage(gameInit.getBallCount(),gameInit.getStrikeCount());
    }

    public String receiveUserNumbers()throws IllegalArgumentException{
        gameInit.initResult();
        GameMessage.askUserInput();
        String inputNumbers = Console.readLine();
        if (inputNumbers.length() != 3){
            throw new IllegalArgumentException();
        }

        for(int i=0;i<3;i++) {
            if (!isLimitDigit(i,inputNumbers)) {
                throw new IllegalArgumentException();
            }
        }
        return inputNumbers;
    }

    public boolean  isLimitDigit(int i, String inputNumbers) {
        return 0 < inputNumbers.charAt(i) -'0' && inputNumbers.charAt(i) -'0' <= 9;
    }

    public void calculateResult(){
        for(int i=0;i<3;i++){
            checkNumbers(i, userNumbers.getUserNumbers(), gameInit.getComputerNumbers());
        }
    }
    public void checkNumbers(int userIndex,String userNumbers, String computerNumbers){
        int computerIndex = -1;
        for(int j=0;j<3;j++){
            if(userNumbers.charAt(userIndex) == computerNumbers.charAt(j)){
                computerIndex = j;
                break;
            }
        }
        countResult(computerIndex, userIndex);
    }
    public void countResult(int computerIndex, int userIndex){
        if(userIndex == computerIndex){
            gameInit.setStrikeCount(gameInit
                    .getStrikeCount()+1);
        }
        if(userIndex != computerIndex && computerIndex != -1){
            gameInit.setBallCount(gameInit
                    .getBallCount()+1);
        }
    }


}
