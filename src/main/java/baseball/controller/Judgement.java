package baseball.controller;
public class Judgement {
    private final CompareNumber compareNum;

    // 생성자
    public Judgement(){
        compareNum = new CompareNumber();
    }

    public int[] getCompareNumber(String computerNum, String playerNum){
        return compareNum.getCompareNumberResult(computerNum, playerNum);
    }

    public boolean isSuccess(){
        if(compareNum.getStrike() == 3) return true;

        return false;
    }
}
