package baseball.controller;

import java.util.List;

public class HintCalculator {
    private final static int LIST_SIZE = 3;
    private final static int SUCCESS_STRIKE_COUNT = 3;
    private final static String strikeString = "스트라이크";
    private final static String ballString = "볼";
    private final static String nothingString = "낫싱";
    private final static String spaceString = " ";
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public HintCalculator(List<Integer> userList, List<Integer> computerList) {
        for (int i = 0; i < LIST_SIZE; ++i) {
            addStrikeCount(userList.get(i), computerList.get(i));
            addBallCount(userList.get(i), computerList);
        }
    }

    public boolean isThreeStrike(){
        return strikeCnt == SUCCESS_STRIKE_COUNT;
    }

    public String getHintString(){
        if(strikeCnt == 0 && ballCnt == 0){
            return nothingString;
        }
        String hintString = "";
        if (ballCnt != 0) {
            hintString+=ballCnt+ballString;
            if(strikeCnt != 0){
                hintString+=spaceString;
            }
        }
        if(strikeCnt!=0){
            hintString+=strikeCnt;
            hintString+=strikeString;
        }
        return hintString;
    }

    private void addStrikeCount(int userDigit, int computerDigit) {
        if(isStrike(userDigit, computerDigit)){
            ++strikeCnt;
        }
    }

    private void addBallCount(int userDigit, List<Integer> computerList) {
        if(isBall(userDigit, computerList)){
            ++ballCnt;;
        }
    }

    private boolean isStrike(Integer userNumber, Integer computerNumber) {
        return userNumber == computerNumber;
    }

    private boolean isBall(Integer userNumber, List<Integer> computerList) {
        return computerList.contains(userNumber);
    }

}
