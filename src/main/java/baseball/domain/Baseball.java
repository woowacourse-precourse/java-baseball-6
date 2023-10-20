package baseball.domain;

public class Baseball {
    private static final Integer GAME_RETRY = 1;
    private static final Integer GAME_END = 2;



    boolean state;

    public Baseball(boolean state){
        this.state=state;
    }

    public boolean isState() {
        return state;
    }




}
