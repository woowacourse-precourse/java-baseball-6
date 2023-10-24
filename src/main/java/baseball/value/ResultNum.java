package baseball.value;

public class ResultNum {

    int[] computerNumber;

    int[] userNumber;

    public void setComputerNum(int[] randomNum){
        computerNumber = randomNum;
    }

    public int[] getComputerNumber(){
        return computerNumber;
    }

    public void setUserNumber(int[] userNum){
        userNumber = userNum;
    }
    public int[] getUserNumber(){return userNumber;}
}
