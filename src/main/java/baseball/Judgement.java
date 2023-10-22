package baseball;

public class Judgement {
    private int ballCount;
    private int strikeCount;
    private Display display;
    public Judgement(int[] userInput, int[] computerNumbers){
        display = new Display();
        calculateCount(userInput, computerNumbers);
    }
    public void printResult(){
        display.printJudgeResult(ballCount, strikeCount);
    }
    public boolean isOut(){
        return (strikeCount == 3);
    }
    private void calculateCount(int[] userInput, int[] computerNumbers){
        for(int userIndex = 0; userIndex < 3; userIndex++){
            countStrike(userInput, computerNumbers, userIndex);
            countBallOneByOne(userInput, computerNumbers, userIndex);
        }
    }
    private void countStrike(int[] userInput, int[] computerNumbers, int index){
        if(userInput[index] == computerNumbers[index]) strikeCount++;
    }
    private void countBallOneByOne(int[] userInput, int[] computerNumbers, int userIndex){
        for(int computerIndex = 0; computerIndex < 3; computerIndex++){
            if(userIndex == computerIndex) continue;
            countBall(userInput[userIndex], computerNumbers[computerIndex]);
        }
    }
    private void countBall(int userNumber, int computerNumber){
        if(userNumber == computerNumber){
            ballCount++;
        }
    }
}
