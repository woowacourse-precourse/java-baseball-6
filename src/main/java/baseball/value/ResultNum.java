package baseball.value;

public class ResultNum {

    int[] computerNumber;

    int[] userNumber;

    public void setComputerNum(int[] RandomNum){
        this.computerNumber = RandomNum;
    }

    public int[] getComputerNumber(){
        return computerNumber;
    }

    public void setUserNumber(int[] userNumber){
        this.userNumber = userNumber;
    }
    public int[] getUserNumber(){return userNumber;}
}
