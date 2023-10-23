package baseball;

public class Judgement {
    private int ballCount;
    private int strikeCount;
    private Display display;
    public Judgement(int[] userNumbers, int[] computerNumbers){
        display = new Display();
        calculateCount(userNumbers, computerNumbers);
    }
    public void printResult(){
        display.printJudgeResult(ballCount, strikeCount);
    }
    public boolean isOut(){
        return (strikeCount == 3);
    }
    private void calculateCount(int[] userNumbers, int[] computerNumbers){
        for(int userIndex = 0; userIndex < 3; userIndex++){
            countStrike(userNumbers, computerNumbers, userIndex);
            countBallOneByOne(userNumbers, computerNumbers, userIndex);
        }
    }
    private void countStrike(int[] userNumbers, int[] computerNumbers, int index){
        if(userNumbers[index] == computerNumbers[index]) strikeCount++;
    }
    private void countBallOneByOne(int[] userNumbers, int[] computerNumbers, int userIndex){
        for(int computerIndex = 0; computerIndex < 3; computerIndex++){
            if(userIndex == computerIndex) continue;
            countBall(userNumbers[userIndex], computerNumbers[computerIndex]);
        }
    }
    private void countBall(int userNumber, int computerNumber){
        if(userNumber == computerNumber){
            ballCount++;
        }
    }
}
