package baseball.Domain;

public class CompareUserWithComputer {
    private String userNumber;
    private String computerNumber;

    private int strikeNum;
    private int ballNum;

    public CompareUserWithComputer(String userNumber, String computerNumber){
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;

        countStrikeNum();
        countBallNum();
    }

    public int getStrikeNum(){
        return strikeNum;
    }

    public int getBallNum(){
        return ballNum;
    }

    private void countStrikeNum(){
        for (int i = 0; i < userNumber.length(); i++) {
            if(userNumber.charAt(i) == computerNumber.charAt(i)){
                this.strikeNum++;
            }
        }
    }

    private void countBallNum(){
        for (int i = 0; i < userNumber.length(); i++) {
            if(computerNumber.contains(String.valueOf(userNumber.charAt(i)))){
                this.ballNum++;
            }
        }
    }
}
