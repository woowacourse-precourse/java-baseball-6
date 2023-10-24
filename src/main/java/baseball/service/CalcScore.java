package baseball.service;

import java.util.List;

public class CalcScore {
    private List<Integer> com;
    private char[] user;
    private int sameNum=0;
    private int strikeNum=0;

    public CalcScore(List<Integer> com, String user){
        this.com = com;
        this.user = user.toCharArray();
        compareNumbers();
    }

    private void compareNumbers(){
        sameNum=0;
        for(int i=0;i<3;i++){
            if(com.contains(Character.getNumericValue(user[i])))
                sameNum++;
        }
    }
    public int calcBall(){
        return sameNum - strikeNum;

    }
    public int calcStrike(){
        for(int i=0;i<3;i++){
            if(com.get(i) ==Character.getNumericValue(user[i]))
                strikeNum++;
        }
        return strikeNum;
    }
}
