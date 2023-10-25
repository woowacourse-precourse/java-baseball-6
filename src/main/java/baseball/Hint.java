package baseball;

import java.util.List;

public class Hint {
    private String result = "낫싱";
    private boolean isFound = false;
    private boolean isComplete = false;
    private int ball = 0;
    private int strike = 0;

    private List<Integer> userNumList;
    private List<Integer> computerNumList;

    public Hint(UserNumber userNumber, ComputerNumber computerNumber){
        this.userNumList = userNumber.getNumberList();
        this.computerNumList = computerNumber.getNumberList();
    }

    public void makeHint(){
        setBallAndStrike();
        if(isFound) setResult();
        printHint();
    }

    private void setBallAndStrike(){
        for(int i=0; i<userNumList.size(); i++){
            if(computerNumList.contains(userNumList.get(i))){
                isFound = true;

                if(computerNumList.indexOf(userNumList.get(i))==i) strike++;
                else ball++;
            }
        }

    }
    private void setResult(){
        if(strike==3) {
            result = "3스트라이크";
            isComplete = true;
        }

        if(ball!=0) result = ball + "볼 ";
        else result = "";

        if(strike!=0) result = result + strike + "스트라이크";
    }

    private void printHint(){
        System.out.println(result);
    }

    public boolean getIsComplete(){
        return isComplete;
    }
}


