package baseball.domain;


import baseball.validator.BaseballValidator;

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

    public void retryAndEnd(Integer number){
        if(BaseballValidator.retryValidator(number)){
            if( number == GAME_RETRY ){
                this.state=true;
            }
            if ( number == GAME_END ){
                this.state=false;
            }
        }
    }
}
