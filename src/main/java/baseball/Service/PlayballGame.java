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
        String computerNumbers = RandomPick.createComputerNumbers();
//        System.out.println("맞춰야할 숫자는: "+computerNumbers);
        gameInit = new GameInit(computerNumbers);
    }
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
//        System.out.println("게임을 시작합니다."+gameInit.getComputerNumbers());
        //게임 결과 계산
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
//        System.out.println(i+"번째 userNumbers는 "+userNumbers.charAt(i));
        int computerIndex = -1;
        for(int j=0;j<3;j++){
//            System.out.println(j+"번째 computerNumbers "+computerNumbers.charAt(j));
            if(userNumbers.charAt(userIndex) == computerNumbers.charAt(j)){
                computerIndex = j;
                break;
            }
        }
        countResult(computerIndex, userIndex);
    }
    public void countResult(int computerIndex, int userIndex){
        if(userIndex == computerIndex){
//            System.out.println(userIndex+"=="+computerIndex);
            gameInit.setStrikeCount(gameInit
                    .getStrikeCount()+1);
        }
        if(userIndex != computerIndex && computerIndex != -1){
//            System.out.println("computerIndex =="+computerIndex+"userIndex == "+userIndex);
            gameInit.setBallCount(gameInit
                    .getBallCount()+1);
        }
    }


}
