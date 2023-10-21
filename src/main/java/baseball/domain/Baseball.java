package baseball.domain;


import baseball.validator.BaseballValidator;

public class Baseball {
    private static final Integer GAME_RESTART = 1;
    private static final Integer GAME_SHUTDOWN = 2;
    private boolean state;

    public Baseball(boolean state){
        this.state=state;
    }

    public boolean restart() {
        return state;
    }

    public void restartAndShutdown(Integer number){
        if(BaseballValidator.restartValidator(number)){
            if( number == GAME_RESTART ){
                this.state=true;
            }
            if ( number == GAME_SHUTDOWN ){
                this.state=false;
            }
        }
    }
}
