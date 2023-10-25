package baseball.model;

public class ReplayNumber {
    public String replayNumber;

    public ReplayNumber(String replayNumber){
        isReplayNumberCorrect(replayNumber);
        this.replayNumber = replayNumber;
    }
    public String getReplayNumber(){
        return replayNumber;
    }

    public static void isReplayNumberCorrect(String inputReplayNumber) throws IllegalArgumentException{
        if(!inputReplayNumber.equals("1")&&!inputReplayNumber.equals("2")){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
