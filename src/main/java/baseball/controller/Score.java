package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class Score {
    // member variables
    private final List<Integer> scoreBoard;
    // constructor
    public Score() {
        this.scoreBoard = new ArrayList<>();
        for(int i = 0;i < 2;i++) this.scoreBoard.add(0);
    }
    // clear List of scoreBoard
    private void clearBoard(){
        for(int i = 0;i < 2;i++) scoreBoard.set(i, 0);
    }
    // counting number of strike
    private void isStrike(final List<Integer> com, final List<Integer> user){
        // local variable
        int comNum, userNum;
        for(int i = 0;i < com.size();i++){
            comNum = com.get(i);
            userNum = user.get(i);
            if(comNum == userNum){
                int currentValue = scoreBoard.get(0);
                scoreBoard.set(0, currentValue+1);
            }
        }
    }

    // counting number of ball
    private void isBall(List<Integer> com, List<Integer> user){
        // local variable
        int comIdx, userIdx;
        for(int num : com){
            boolean isContain = user.contains(num);
            if(isContain){
                comIdx = com.indexOf(num);
                userIdx = user.indexOf(num);
                if(comIdx != userIdx){
                    int currentValue = scoreBoard.get(1);
                    scoreBoard.set(1, currentValue+1);
                }
            }
        }
    }

    public Boolean checkScore(List<Integer> com, List<Integer> user){
        // local variable
        int strikeCnt;
        int ballCnt;
        // call clear method & counting score method
        clearBoard();
        isStrike(com, user);
        isBall(com, user);
        strikeCnt = scoreBoard.get(0);
        ballCnt = scoreBoard.get(1);
        // checking score
        if(strikeCnt == 3){
            System.out.println("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
            System.out.println("게임 종료");
            return true;
        }
        else if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("낫싱");
        }
        else{
            if(strikeCnt == 0) System.out.printf("%d볼\n", ballCnt);
            else if(ballCnt == 0) System.out.printf("%d스트라이크\n", strikeCnt);
            else System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
        }
        return false;
    }
}
