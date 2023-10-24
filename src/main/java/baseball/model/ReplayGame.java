package baseball.model;

public class ReplayGame {
    private String replayNumber;

    public ReplayGame(String replayNumber){
        isCorrectCommand(replayNumber);
        this.replayNumber=replayNumber;
    }

    public String getReplayNumber(){
        return replayNumber;
    }

    public static void isCorrectCommand(String replayNumber) throws IllegalArgumentException{
        if(!replayNumber.equals("1") && !replayNumber.equals("2")){
            throw new IllegalArgumentException("재시작은 1 종료는 2를 입력해주세요.");
        }
    }

}
