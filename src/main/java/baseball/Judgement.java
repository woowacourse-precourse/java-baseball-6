package baseball;

public class Judgement {
    int ballCount;
    int strikeCount;
    Display display;
    public Judgement(int ballCount, int strikeCount){
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        display = new Display();
    }
    public void printResult(){
        display.printJudgeResult(ballCount, strikeCount);
    }
    public boolean isOut(){
        return (strikeCount == 3);
    }
}
