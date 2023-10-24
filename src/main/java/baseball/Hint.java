package baseball;

import java.util.List;

public class Hint {
    private String result = "낫싱";
    private boolean found = false;
    private boolean isSame = false;
    private int ball = 0;
    private int strike = 0;

    public Hint(List<Integer> you, List<Integer> computerNumber){
        setBallAndStrike(you, computerNumber);
        if(found) setResult();
    }

    public void setBallAndStrike(List<Integer> userNumber, List<Integer> computerNumber){
        // Hint 클래스의 필드 ball 과 strike 값 정하기
        for(int i=0; i<userNumber.size(); i++){
            if(computerNumber.contains(userNumber.get(i))){
                found = true;
                if(computerNumber.indexOf(userNumber.get(i))==i) strike++;
                else ball++;
            }
        }

    }
    public void setResult(){
        // Hint 클래스의 String 필드 result 의 값 정하기
        if(strike==3) {
            result = "3스트라이크";
            isSame = true;
        }

        if(ball!=0) result = ball + "볼 ";
        else result = "";

        if(strike!=0) result = result + strike + "스트라이크";
    }

    public void printHint(){
        System.out.println(result);
    }

    public boolean getIsSame(){
        return isSame;
    }
}


