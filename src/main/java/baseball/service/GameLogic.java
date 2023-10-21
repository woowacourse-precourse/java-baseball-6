package baseball.service;

import baseball.view.PrintMessage;
import baseball.vo.Computer;
import baseball.vo.User;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    public static List<Integer> generateRandomNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static boolean compareResult(Computer computer, User user){
        boolean gameEnd=false;
        int strikeCount=getStrikeCount(computer,user);
        int ballCount=getBallCount(computer,user);
        boolean nothing=getNothing(strikeCount,ballCount);
        if(nothing){
            PrintMessage.printNothing();
        }else if(ballCount>0&&strikeCount>0){
            PrintMessage.printBall(ballCount);
            PrintMessage.printStrike(strikeCount);
        }else if(ballCount>0){
            PrintMessage.printBall(ballCount);
        }else if(strikeCount>0){
            PrintMessage.printStrike(strikeCount);
        }
        if(strikeCount==3){
            gameEnd=true;
        }
        return gameEnd;
    }
    public static int getStrikeCount(Computer computer, User user){
        int strikeCount=0;
        for(int i=0;i<3;i++){
            if(user.getNumber(i)==computer.getNumber(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }
    public static int getBallCount(Computer computer, User user){
        int ballCount=0;
        for(int i=0;i<3;i++){
            int userNumber=user.getNumber(i);
            if(computer.getIndex(userNumber)!=-1&&computer.getNumber(i)!=userNumber){
                ballCount++;
            }
        }
        return ballCount;
    }
    public static boolean getNothing(int strkeNumber, int ballNumber){
        boolean nothing=false;
        if(strkeNumber+ballNumber>0){
            nothing=false;
        }else{
            nothing=true;
        }
        return nothing;
    }

}
