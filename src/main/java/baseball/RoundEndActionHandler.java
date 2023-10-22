package baseball;

public class RoundEndActionHandler implements PlayerInputHandler<RoundEndAction>{
    RoundEndAction roundEndAction;
    public RoundEndActionHandler(){

    }
    public void handle(String stringRoundEndAction){
        if (stringRoundEndAction.equals(RoundEndAction.CONTINUE.getValue())){
            this.roundEndAction =  RoundEndAction.CONTINUE;
            return;
        }
        if (stringRoundEndAction.equals(RoundEndAction.QUIT.getValue())){
            this.roundEndAction =  RoundEndAction.QUIT;
            return;
        }
        throw new IllegalArgumentException();
    }
    public RoundEndAction getHandledResult(){
        return this.roundEndAction;
    }

}
