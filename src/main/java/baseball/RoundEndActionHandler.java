package baseball;

public class RoundEndActionHandler implements PlayerInputHandler<RoundEndAction>{
    RoundEndAction roundEndAction;

    public RoundEndActionHandler(){}

    public void handle(String stringRoundEndAction){
        if (stringRoundEndAction.equals(RoundEndAction.CONTINUE.getValue())){
            roundEndAction =  RoundEndAction.CONTINUE;
            return;
        }

        if (stringRoundEndAction.equals(RoundEndAction.QUIT.getValue())){
            roundEndAction =  RoundEndAction.QUIT;
            return;
        }
        System.out.println(RoundEndAction.CONTINUE.getValue() + " 또는 " + RoundEndAction.QUIT.getValue() + "를 입력해주세요.");
        throw new IllegalArgumentException();
    }
    public RoundEndAction getHandledResult(){
        return roundEndAction;
    }
}
