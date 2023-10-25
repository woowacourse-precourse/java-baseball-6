package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private static final int BOARD_SIZE = 2;
    private final List<Integer> scoreBoard;

    // constructor
    public Score() {
        this.scoreBoard = new ArrayList<>();
        for(int i = 0;i < BOARD_SIZE;i++) this.scoreBoard.add(0);
    }

    // final checkScore
    public Boolean checkScore(Computer com, User user){
        // call counting method
        countStrikesAndBalls(com, user);
        // local variable
        int strikeCnt = scoreBoard.get(0);
        int ballCnt = scoreBoard.get(1);
        // checking score
        if(strikeCnt == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("낫싱");
        }
        else if(strikeCnt == 0) {
            System.out.printf("%d볼\n", ballCnt);
        }
        else if(ballCnt == 0) {
            System.out.printf("%d스트라이크\n", strikeCnt);
        }
        else if(strikeCnt > 0 || ballCnt > 0){
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
        }
        return false;
    }

    // clear List of scoreBoard
    private void clearScoreBoard(){
        for(int i = 0;i < BOARD_SIZE;i++) scoreBoard.set(i, 0);
    }

    // counting number of strike
    private void countStrikes(final List<Integer> com, final List<Integer> user){
        // local variable
        int currentValue;
        for(int i = 0;i < com.size();i++){
            if(com.get(i).equals(user.get(i))){
                currentValue = scoreBoard.get(0);
                scoreBoard.set(0, currentValue+1);
            }
        }
    }

    // counting number of ball
    private void countBalls(List<Integer> com, List<Integer> user){
        // local variable
        int comIdx, userIdx, currentValue;
        boolean isContain;
        for(int num : com){
            isContain = user.contains(num);
            if(isContain){
                comIdx = com.indexOf(num);
                userIdx = user.indexOf(num);
                if(comIdx != userIdx){
                    currentValue = scoreBoard.get(1);
                    scoreBoard.set(1, currentValue+1);
                }
            }
        }
    }

    // counting Strikes and Balls
    private void countStrikesAndBalls(Computer comInstance, User userInstance){
        List<Integer> com = comInstance.getNumbers();
        List<Integer> user = userInstance.getNumbers();
        // call clear method & counting score method
        clearScoreBoard();
        countStrikes(com, user);
        countBalls(com, user);
    }
}
