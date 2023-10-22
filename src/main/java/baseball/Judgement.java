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
            if(isStrike(userInput, computerNumbers, userIndex)) strikeCount++;
            else if(isBall(userInput, computerNumbers, userIndex)) ballCount++;
        }
    }
    private boolean isStrike(int[] userInput, int[] computerNumbers, int index){
        return userInput[index] == computerNumbers[index];
    }
    private boolean isBall(int[] userInput, int[] computerNumbers, int userIndex){
        for(int computerIndex = 0; computerIndex < 3; computerIndex++){
            if(userIndex == computerIndex) continue;
            if(userInput[userIndex] == computerNumbers[computerIndex]) return true;
        }
        return false;
    }
}
